package dto
// AUTO-GENERATED Slick data model for table User
trait UserTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table User
   *  @param token Database column token SqlType(varchar)
   *  @param icon Database column icon SqlType(varchar), Default(None)
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param profile Database column profile SqlType(varchar), Default(None)
   *  @param url Database column url SqlType(varchar), Default(None)
   *  @param name Database column name SqlType(varchar) */
  case class UserRow(token: String, icon: Option[String] = None, id: Int, profile: Option[String] = None, url: Option[String] = None, name: String)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[String], <<?[String], <<[Int], <<?[String], <<?[String], <<[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends profile.api.Table[UserRow](_tableTag, Some("pokemon_master"), "user") {
    def * = (token, icon, id, profile, url, name) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(token), icon, Rep.Some(id), profile, url, Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2, _3.get, _4, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column token SqlType(varchar) */
    val token: Rep[String] = column[String]("token")
    /** Database column icon SqlType(varchar), Default(None) */
    val icon: Rep[Option[String]] = column[Option[String]]("icon", O.Default(None))
    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column profile SqlType(varchar), Default(None) */
    val profile: Rep[Option[String]] = column[Option[String]]("profile", O.Default(None))
    /** Database column url SqlType(varchar), Default(None) */
    val url: Rep[Option[String]] = column[Option[String]]("url", O.Default(None))
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
