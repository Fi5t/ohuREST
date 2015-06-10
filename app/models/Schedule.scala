package models

import play.api.libs.json.Json

/**
 * @author Fi5t
 * @version
 */
object Schedule {
  case class Release(color: Int, technology: String, title: String, id: Int)
  case class Week(releases: List[Release], number: Int, duration: Int)
  case class ScheduleItem(cinema_id: Int, weeks: List[Week])
  case class Schedule(list: List[ScheduleItem])

  implicit val releaseWrites = Json.writes[Release]
  implicit val releaseReads = Json.reads[Release]

  implicit val weekWrites = Json.writes[Week]
  implicit val weekReads = Json.reads[Week]

  implicit val scheduleItemWrites = Json.writes[ScheduleItem]
  implicit val scheduleItemReads = Json.reads[ScheduleItem]

  implicit val scheduleWrites = Json.writes[Schedule]
  implicit val scheduleReads = Json.reads[Schedule]

  val releases = List(Release(3, "stub", "Мордекай", 4044))

  val weeks = List(
    Week(releases, 25, 330),
    Week(releases, 26, 220)
  )

  val scheduleItems = List(
    ScheduleItem(168, weeks),
    ScheduleItem(602, weeks),
    ScheduleItem(2238, weeks)
  )

  val list = Schedule(scheduleItems)
}
