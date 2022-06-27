package dto
// AUTO-GENERATED Slick data model for table PokemonAbility
trait PokemonAbilityTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table PokemonAbility
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param pokemonId Database column pokemon_id SqlType(int4)
   *  @param ability Database column ability SqlType(int4) */
  case class PokemonAbilityRow(id: Int, pokemonId: Int, ability: Int)
  /** GetResult implicit for fetching PokemonAbilityRow objects using plain SQL queries */
  implicit def GetResultPokemonAbilityRow(implicit e0: GR[Int]): GR[PokemonAbilityRow] = GR{
    prs => import prs._
    PokemonAbilityRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table pokemon_ability. Objects of this class serve as prototypes for rows in queries. */
  class PokemonAbility(_tableTag: Tag) extends profile.api.Table[PokemonAbilityRow](_tableTag, Some("pokemon_master"), "pokemon_ability") {
    def * = (id, pokemonId, ability) <> (PokemonAbilityRow.tupled, PokemonAbilityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(pokemonId), Rep.Some(ability))).shaped.<>({r=>import r._; _1.map(_=> PokemonAbilityRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column pokemon_id SqlType(int4) */
    val pokemonId: Rep[Int] = column[Int]("pokemon_id")
    /** Database column ability SqlType(int4) */
    val ability: Rep[Int] = column[Int]("ability")

    /** Foreign key referencing Pokemon (database name pokemon_ability_pokemon_pokemon_id_fk) */
    lazy val pokemonFk = foreignKey("pokemon_ability_pokemon_pokemon_id_fk", pokemonId, Pokemon)(r => r.pokemonId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing PokemonAbilityMaster (database name pokemon_ability_pokemon_ability_master_id_fk) */
    lazy val pokemonAbilityMasterFk = foreignKey("pokemon_ability_pokemon_ability_master_id_fk", ability, PokemonAbilityMaster)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table PokemonAbility */
  lazy val PokemonAbility = new TableQuery(tag => new PokemonAbility(tag))
}
