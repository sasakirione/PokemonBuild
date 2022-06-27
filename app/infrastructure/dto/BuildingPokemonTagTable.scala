package dto
// AUTO-GENERATED Slick data model for table BuildingPokemonTag
trait BuildingPokemonTagTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table BuildingPokemonTag
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param buildingPokemonId Database column building_pokemon_id SqlType(int4), Default(None)
   *  @param tag Database column tag SqlType(int4), Default(None) */
  case class BuildingPokemonTagRow(id: Int, buildingPokemonId: Option[Int] = None, tag: Option[Int] = None)
  /** GetResult implicit for fetching BuildingPokemonTagRow objects using plain SQL queries */
  implicit def GetResultBuildingPokemonTagRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[BuildingPokemonTagRow] = GR{
    prs => import prs._
    BuildingPokemonTagRow.tupled((<<[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table building_pokemon_tag. Objects of this class serve as prototypes for rows in queries. */
  class BuildingPokemonTag(_tableTag: Tag) extends profile.api.Table[BuildingPokemonTagRow](_tableTag, Some("pokemon_master"), "building_pokemon_tag") {
    def * = (id, buildingPokemonId, tag) <> (BuildingPokemonTagRow.tupled, BuildingPokemonTagRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), buildingPokemonId, tag)).shaped.<>({r=>import r._; _1.map(_=> BuildingPokemonTagRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column building_pokemon_id SqlType(int4), Default(None) */
    val buildingPokemonId: Rep[Option[Int]] = column[Option[Int]]("building_pokemon_id", O.Default(None))
    /** Database column tag SqlType(int4), Default(None) */
    val tag: Rep[Option[Int]] = column[Option[Int]]("tag", O.Default(None))

    /** Foreign key referencing BuildingPokemon (database name building_pokemon_tag_building_pokemon_id_fk) */
    lazy val buildingPokemonFk = foreignKey("building_pokemon_tag_building_pokemon_id_fk", buildingPokemonId, BuildingPokemon)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BuildingPokemonTag */
  lazy val BuildingPokemonTag = new TableQuery(tag => new BuildingPokemonTag(tag))
}
