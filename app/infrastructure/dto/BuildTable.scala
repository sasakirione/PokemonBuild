package dto
// AUTO-GENERATED Slick data model for table Build
trait BuildTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Build
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param buildingName Database column building_name SqlType(varchar), Default(None)
   *  @param buildingExplanation Database column building_explanation SqlType(varchar), Default(None)
   *  @param userId Database column user_id SqlType(int4), Default(None) */
  case class BuildRow(id: Int, buildingName: Option[String] = None, buildingExplanation: Option[String] = None, userId: Option[Int] = None)
  /** GetResult implicit for fetching BuildRow objects using plain SQL queries */
  implicit def GetResultBuildRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[BuildRow] = GR{
    prs => import prs._
    BuildRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table build. Objects of this class serve as prototypes for rows in queries. */
  class Build(_tableTag: Tag) extends profile.api.Table[BuildRow](_tableTag, Some("pokemon_master"), "build") {
    def * = (id, buildingName, buildingExplanation, userId) <> (BuildRow.tupled, BuildRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), buildingName, buildingExplanation, userId)).shaped.<>({r=>import r._; _1.map(_=> BuildRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column building_name SqlType(varchar), Default(None) */
    val buildingName: Rep[Option[String]] = column[Option[String]]("building_name", O.Default(None))
    /** Database column building_explanation SqlType(varchar), Default(None) */
    val buildingExplanation: Rep[Option[String]] = column[Option[String]]("building_explanation", O.Default(None))
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))

    /** Foreign key referencing User (database name user) */
    lazy val userFk = foreignKey("user", userId, User)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Build */
  lazy val Build = new TableQuery(tag => new Build(tag))
}
