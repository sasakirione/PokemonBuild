package dto
// AUTO-GENERATED Slick data model for table PokemonAbilityMaster
trait PokemonAbilityMasterTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table PokemonAbilityMaster
   *  @param id Database column id SqlType(int4), PrimaryKey
   *  @param name Database column name SqlType(varchar) */
  case class PokemonAbilityMasterRow(id: Int, name: String)
  /** GetResult implicit for fetching PokemonAbilityMasterRow objects using plain SQL queries */
  implicit def GetResultPokemonAbilityMasterRow(implicit e0: GR[Int], e1: GR[String]): GR[PokemonAbilityMasterRow] = GR{
    prs => import prs._
    PokemonAbilityMasterRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table pokemon_ability_master. Objects of this class serve as prototypes for rows in queries. */
  class PokemonAbilityMaster(_tableTag: Tag) extends profile.api.Table[PokemonAbilityMasterRow](_tableTag, Some("pokemon_master"), "pokemon_ability_master") {
    def * = (id, name) <> (PokemonAbilityMasterRow.tupled, PokemonAbilityMasterRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name))).shaped.<>({r=>import r._; _1.map(_=> PokemonAbilityMasterRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int4), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
  }
  /** Collection-like TableQuery object for table PokemonAbilityMaster */
  lazy val PokemonAbilityMaster = new TableQuery(tag => new PokemonAbilityMaster(tag))
}
