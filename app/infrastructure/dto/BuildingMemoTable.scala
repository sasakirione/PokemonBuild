package dto
// AUTO-GENERATED Slick data model for table BuildingMemo
trait BuildingMemoTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table BuildingMemo
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param buildingId Database column building_id SqlType(int4), Default(None)
   *  @param `type` Database column type SqlType(int4), Default(1)
   *  @param value Database column value SqlType(varchar), Default(None) */
  case class BuildingMemoRow(id: Int, buildingId: Option[Int] = None, `type`: Int = 1, value: Option[String] = None)
  /** GetResult implicit for fetching BuildingMemoRow objects using plain SQL queries */
  implicit def GetResultBuildingMemoRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[BuildingMemoRow] = GR{
    prs => import prs._
    BuildingMemoRow.tupled((<<[Int], <<?[Int], <<[Int], <<?[String]))
  }
  /** Table description of table building_memo. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class BuildingMemo(_tableTag: Tag) extends profile.api.Table[BuildingMemoRow](_tableTag, Some("pokemon_master"), "building_memo") {
    def * = (id, buildingId, `type`, value) <> (BuildingMemoRow.tupled, BuildingMemoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), buildingId, Rep.Some(`type`), value)).shaped.<>({r=>import r._; _1.map(_=> BuildingMemoRow.tupled((_1.get, _2, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column building_id SqlType(int4), Default(None) */
    val buildingId: Rep[Option[Int]] = column[Option[Int]]("building_id", O.Default(None))
    /** Database column type SqlType(int4), Default(1)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Int] = column[Int]("type", O.Default(1))
    /** Database column value SqlType(varchar), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("value", O.Default(None))

    /** Foreign key referencing Build (database name building) */
    lazy val buildFk = foreignKey("building", buildingId, Build)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BuildingMemo */
  lazy val BuildingMemo = new TableQuery(tag => new BuildingMemo(tag))
}
