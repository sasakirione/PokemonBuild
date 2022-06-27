package dto
// AUTO-GENERATED Slick data model for table BuildingPokemon
trait BuildingPokemonTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  /** Entity class storing rows of table BuildingPokemon
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param buildingId Database column building_id SqlType(int4), Default(None)
   *  @param pokemonId Database column pokemon_id SqlType(int4)
   *  @param evH Database column ev_h SqlType(int4), Default(Some(0))
   *  @param evA Database column ev_a SqlType(int4), Default(Some(0))
   *  @param evB Database column ev_b SqlType(int4), Default(Some(0))
   *  @param evC Database column ev_c SqlType(int4), Default(Some(0))
   *  @param evD Database column ev_d SqlType(int4), Default(Some(0))
   *  @param evS Database column ev_s SqlType(int4), Default(Some(0))
   *  @param ivH Database column iv_h SqlType(int4), Default(Some(31))
   *  @param ivA Database column iv_a SqlType(int4), Default(Some(31))
   *  @param ivB Database column iv_b SqlType(int4), Default(Some(31))
   *  @param ivC Database column iv_c SqlType(int4), Default(Some(31))
   *  @param ivD Database column iv_d SqlType(int4), Default(Some(31))
   *  @param ivS Database column iv_s SqlType(int4), Default(Some(31))
   *  @param goodId Database column good_id SqlType(int4)
   *  @param abilityId Database column ability_id SqlType(int4)
   *  @param natureId Database column nature_id SqlType(int4)
   *  @param shiny Database column shiny SqlType(bool), Default(Some(false)) */
  case class BuildingPokemonRow(id: Int, buildingId: Option[Int] = None, pokemonId: Int, evH: Option[Int] = Some(0), evA: Option[Int] = Some(0), evB: Option[Int] = Some(0), evC: Option[Int] = Some(0), evD: Option[Int] = Some(0), evS: Option[Int] = Some(0), ivH: Option[Int] = Some(31), ivA: Option[Int] = Some(31), ivB: Option[Int] = Some(31), ivC: Option[Int] = Some(31), ivD: Option[Int] = Some(31), ivS: Option[Int] = Some(31), goodId: Int, abilityId: Int, natureId: Int, shiny: Option[Boolean] = Some(false))
  /** GetResult implicit for fetching BuildingPokemonRow objects using plain SQL queries */
  implicit def GetResultBuildingPokemonRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[Boolean]]): GR[BuildingPokemonRow] = GR{
    prs => import prs._
    BuildingPokemonRow.tupled((<<[Int], <<?[Int], <<[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<[Int], <<[Int], <<[Int], <<?[Boolean]))
  }
  /** Table description of table building_pokemon. Objects of this class serve as prototypes for rows in queries. */
  class BuildingPokemon(_tableTag: Tag) extends profile.api.Table[BuildingPokemonRow](_tableTag, Some("pokemon_master"), "building_pokemon") {
    def * = (id, buildingId, pokemonId, evH, evA, evB, evC, evD, evS, ivH, ivA, ivB, ivC, ivD, ivS, goodId, abilityId, natureId, shiny) <> (BuildingPokemonRow.tupled, BuildingPokemonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), buildingId, Rep.Some(pokemonId), evH, evA, evB, evC, evD, evS, ivH, ivA, ivB, ivC, ivD, ivS, Rep.Some(goodId), Rep.Some(abilityId), Rep.Some(natureId), shiny)).shaped.<>({r=>import r._; _1.map(_=> BuildingPokemonRow.tupled((_1.get, _2, _3.get, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16.get, _17.get, _18.get, _19)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column building_id SqlType(int4), Default(None) */
    val buildingId: Rep[Option[Int]] = column[Option[Int]]("building_id", O.Default(None))
    /** Database column pokemon_id SqlType(int4) */
    val pokemonId: Rep[Int] = column[Int]("pokemon_id")
    /** Database column ev_h SqlType(int4), Default(Some(0)) */
    val evH: Rep[Option[Int]] = column[Option[Int]]("ev_h", O.Default(Some(0)))
    /** Database column ev_a SqlType(int4), Default(Some(0)) */
    val evA: Rep[Option[Int]] = column[Option[Int]]("ev_a", O.Default(Some(0)))
    /** Database column ev_b SqlType(int4), Default(Some(0)) */
    val evB: Rep[Option[Int]] = column[Option[Int]]("ev_b", O.Default(Some(0)))
    /** Database column ev_c SqlType(int4), Default(Some(0)) */
    val evC: Rep[Option[Int]] = column[Option[Int]]("ev_c", O.Default(Some(0)))
    /** Database column ev_d SqlType(int4), Default(Some(0)) */
    val evD: Rep[Option[Int]] = column[Option[Int]]("ev_d", O.Default(Some(0)))
    /** Database column ev_s SqlType(int4), Default(Some(0)) */
    val evS: Rep[Option[Int]] = column[Option[Int]]("ev_s", O.Default(Some(0)))
    /** Database column iv_h SqlType(int4), Default(Some(31)) */
    val ivH: Rep[Option[Int]] = column[Option[Int]]("iv_h", O.Default(Some(31)))
    /** Database column iv_a SqlType(int4), Default(Some(31)) */
    val ivA: Rep[Option[Int]] = column[Option[Int]]("iv_a", O.Default(Some(31)))
    /** Database column iv_b SqlType(int4), Default(Some(31)) */
    val ivB: Rep[Option[Int]] = column[Option[Int]]("iv_b", O.Default(Some(31)))
    /** Database column iv_c SqlType(int4), Default(Some(31)) */
    val ivC: Rep[Option[Int]] = column[Option[Int]]("iv_c", O.Default(Some(31)))
    /** Database column iv_d SqlType(int4), Default(Some(31)) */
    val ivD: Rep[Option[Int]] = column[Option[Int]]("iv_d", O.Default(Some(31)))
    /** Database column iv_s SqlType(int4), Default(Some(31)) */
    val ivS: Rep[Option[Int]] = column[Option[Int]]("iv_s", O.Default(Some(31)))
    /** Database column good_id SqlType(int4) */
    val goodId: Rep[Int] = column[Int]("good_id")
    /** Database column ability_id SqlType(int4) */
    val abilityId: Rep[Int] = column[Int]("ability_id")
    /** Database column nature_id SqlType(int4) */
    val natureId: Rep[Int] = column[Int]("nature_id")
    /** Database column shiny SqlType(bool), Default(Some(false)) */
    val shiny: Rep[Option[Boolean]] = column[Option[Boolean]]("shiny", O.Default(Some(false)))

    /** Foreign key referencing Build (database name building) */
    lazy val buildFk = foreignKey("building", buildingId, Build)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Pokemon (database name building_pokemon_pokemon_pokemon_id_fk) */
    lazy val pokemonFk = foreignKey("building_pokemon_pokemon_pokemon_id_fk", pokemonId, Pokemon)(r => r.pokemonId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BuildingPokemon */
  lazy val BuildingPokemon = new TableQuery(tag => new BuildingPokemon(tag))
}
