package dto
// AUTO-GENERATED Slick data model for table PokemonBase
trait PokemonBaseTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table PokemonBase
   *  @param id Database column id SqlType(int4), PrimaryKey
   *  @param h Database column h SqlType(int4)
   *  @param a Database column a SqlType(int4)
   *  @param b Database column b SqlType(int4)
   *  @param c Database column c SqlType(int4)
   *  @param d Database column d SqlType(int4)
   *  @param s Database column s SqlType(int4) */
  case class PokemonBaseRow(id: Int, h: Int, a: Int, b: Int, c: Int, d: Int, s: Int)
  /** GetResult implicit for fetching PokemonBaseRow objects using plain SQL queries */
  implicit def GetResultPokemonBaseRow(implicit e0: GR[Int]): GR[PokemonBaseRow] = GR{
    prs => import prs._
    PokemonBaseRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table pokemon_base. Objects of this class serve as prototypes for rows in queries. */
  class PokemonBase(_tableTag: Tag) extends profile.api.Table[PokemonBaseRow](_tableTag, Some("pokemon_master"), "pokemon_base") {
    def * = (id, h, a, b, c, d, s) <> (PokemonBaseRow.tupled, PokemonBaseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(h), Rep.Some(a), Rep.Some(b), Rep.Some(c), Rep.Some(d), Rep.Some(s))).shaped.<>({r=>import r._; _1.map(_=> PokemonBaseRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int4), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column h SqlType(int4) */
    val h: Rep[Int] = column[Int]("h")
    /** Database column a SqlType(int4) */
    val a: Rep[Int] = column[Int]("a")
    /** Database column b SqlType(int4) */
    val b: Rep[Int] = column[Int]("b")
    /** Database column c SqlType(int4) */
    val c: Rep[Int] = column[Int]("c")
    /** Database column d SqlType(int4) */
    val d: Rep[Int] = column[Int]("d")
    /** Database column s SqlType(int4) */
    val s: Rep[Int] = column[Int]("s")

    /** Foreign key referencing Pokemon (database name pokemon_base_pokemon_pokemon_id_fk) */
    lazy val pokemonFk = foreignKey("pokemon_base_pokemon_pokemon_id_fk", id, Pokemon)(r => r.pokemonId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table PokemonBase */
  lazy val PokemonBase = new TableQuery(tag => new PokemonBase(tag))
}
