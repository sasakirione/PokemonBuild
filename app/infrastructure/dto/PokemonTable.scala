package dto
// AUTO-GENERATED Slick data model for table Pokemon
trait PokemonTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table Pokemon
   *  @param id Database column id SqlType(int4)
   *  @param form Database column form SqlType(int4), Default(0)
   *  @param pokemonId Database column pokemon_id SqlType(serial), AutoInc
   *  @param name Database column name SqlType(varchar) */
  case class PokemonRow(id: Int, form: Int = 0, pokemonId: Int, name: String)
  /** GetResult implicit for fetching PokemonRow objects using plain SQL queries */
  implicit def GetResultPokemonRow(implicit e0: GR[Int], e1: GR[String]): GR[PokemonRow] = GR{
    prs => import prs._
    PokemonRow.tupled((<<[Int], <<[Int], <<[Int], <<[String]))
  }
  /** Table description of table pokemon. Objects of this class serve as prototypes for rows in queries. */
  class Pokemon(_tableTag: Tag) extends profile.api.Table[PokemonRow](_tableTag, Some("pokemon_master"), "pokemon") {
    def * = (id, form, pokemonId, name) <> (PokemonRow.tupled, PokemonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(form), Rep.Some(pokemonId), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> PokemonRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int4) */
    val id: Rep[Int] = column[Int]("id")
    /** Database column form SqlType(int4), Default(0) */
    val form: Rep[Int] = column[Int]("form", O.Default(0))
    /** Database column pokemon_id SqlType(serial), AutoInc */
    val pokemonId: Rep[Int] = column[Int]("pokemon_id", O.AutoInc)
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")

    /** Primary key of Pokemon (database name pokemon_pk) */
    val pk = primaryKey("pokemon_pk", (id, form))

    /** Uniqueness Index over (pokemonId) (database name pokemon_pokemon_id_uindex) */
    val index1 = index("pokemon_pokemon_id_uindex", pokemonId, unique=true)
  }
  /** Collection-like TableQuery object for table Pokemon */
  lazy val Pokemon = new TableQuery(tag => new Pokemon(tag))
}
