package dto
// AUTO-GENERATED Slick data model for table BuildingPokemonMove
trait BuildingPokemonMoveTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table BuildingPokemonMove
   *  @param id Database column id SqlType(int4), PrimaryKey
   *  @param move1 Database column move1 SqlType(int4)
   *  @param move2 Database column move2 SqlType(int4)
   *  @param move3 Database column move3 SqlType(int4)
   *  @param move4 Database column move4 SqlType(int4) */
  case class BuildingPokemonMoveRow(id: Int, move1: Int, move2: Int, move3: Int, move4: Int)
  /** GetResult implicit for fetching BuildingPokemonMoveRow objects using plain SQL queries */
  implicit def GetResultBuildingPokemonMoveRow(implicit e0: GR[Int]): GR[BuildingPokemonMoveRow] = GR{
    prs => import prs._
    BuildingPokemonMoveRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table building_pokemon_move. Objects of this class serve as prototypes for rows in queries. */
  class BuildingPokemonMove(_tableTag: Tag) extends profile.api.Table[BuildingPokemonMoveRow](_tableTag, Some("pokemon_master"), "building_pokemon_move") {
    def * = (id, move1, move2, move3, move4) <> (BuildingPokemonMoveRow.tupled, BuildingPokemonMoveRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(move1), Rep.Some(move2), Rep.Some(move3), Rep.Some(move4))).shaped.<>({r=>import r._; _1.map(_=> BuildingPokemonMoveRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int4), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column move1 SqlType(int4) */
    val move1: Rep[Int] = column[Int]("move1")
    /** Database column move2 SqlType(int4) */
    val move2: Rep[Int] = column[Int]("move2")
    /** Database column move3 SqlType(int4) */
    val move3: Rep[Int] = column[Int]("move3")
    /** Database column move4 SqlType(int4) */
    val move4: Rep[Int] = column[Int]("move4")

    /** Foreign key referencing BuildingPokemon (database name building_pokemon_move_building_pokemon_id_fk) */
    lazy val buildingPokemonFk = foreignKey("building_pokemon_move_building_pokemon_id_fk", id, BuildingPokemon)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BuildingPokemonMove */
  lazy val BuildingPokemonMove = new TableQuery(tag => new BuildingPokemonMove(tag))
}
