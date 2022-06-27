package dto
// AUTO-GENERATED Slick data model for table PokemonType
trait PokemonTypeTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table PokemonType
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param pokemonId Database column pokemon_id SqlType(int4)
   *  @param `type` Database column type SqlType(int4) */
  case class PokemonTypeRow(id: Int, pokemonId: Int, `type`: Int)
  /** GetResult implicit for fetching PokemonTypeRow objects using plain SQL queries */
  implicit def GetResultPokemonTypeRow(implicit e0: GR[Int]): GR[PokemonTypeRow] = GR{
    prs => import prs._
    PokemonTypeRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table pokemon_type. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class PokemonType(_tableTag: Tag) extends profile.api.Table[PokemonTypeRow](_tableTag, Some("pokemon_master"), "pokemon_type") {
    def * = (id, pokemonId, `type`) <> (PokemonTypeRow.tupled, PokemonTypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(pokemonId), Rep.Some(`type`))).shaped.<>({r=>import r._; _1.map(_=> PokemonTypeRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column pokemon_id SqlType(int4) */
    val pokemonId: Rep[Int] = column[Int]("pokemon_id")
    /** Database column type SqlType(int4)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Int] = column[Int]("type")

    /** Foreign key referencing Pokemon (database name pokemon_type_pokemon_pokemon_id_fk) */
    lazy val pokemonFk = foreignKey("pokemon_type_pokemon_pokemon_id_fk", pokemonId, Pokemon)(r => r.pokemonId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing PokemonTypeMaster (database name pokemon_type_pokemon_type_master_id_fk) */
    lazy val pokemonTypeMasterFk = foreignKey("pokemon_type_pokemon_type_master_id_fk", `type`, PokemonTypeMaster)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table PokemonType */
  lazy val PokemonType = new TableQuery(tag => new PokemonType(tag))
}
