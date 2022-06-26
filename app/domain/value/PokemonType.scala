package domain.value

class PokemonType(val typeNames: Seq[String]) {
  val pokemonType: Seq[PokemonTypes] = typeNames.map(name => convertPokemonType(name))

  private def convertPokemonType(pokemonType: String): PokemonTypes = {
    pokemonType match {
      case "ノーマル" => PokemonTypes.NORMAL
      case "ほのお" => PokemonTypes.FIRE
      case "みず" => PokemonTypes.WATER
      case "でんき" => PokemonTypes.ELECTRIC
      case "くさ" => PokemonTypes.GRASS
      case "こおり" => PokemonTypes.ICE
      case "かくとう" => PokemonTypes.FIGHTING
      case "どく" => PokemonTypes.POISON
      case "じめん" => PokemonTypes.GROUND
      case "ひこう" => PokemonTypes.FLYING
      case "エスパー" => PokemonTypes.PSYCHIC
      case "むし" => PokemonTypes.BUG
      case "いわ" => PokemonTypes.ROCK
      case "ゴースト" => PokemonTypes.GHOST
      case "ドラゴン" => PokemonTypes.DRAGON
      case "あく" => PokemonTypes.DARK
      case "はがね" => PokemonTypes.STEEL
      case "フェアリー" => PokemonTypes.FAIRY
      case _ => throw new IllegalArgumentException("Bad Type")
    }
  }
}

sealed trait PokemonTypes
object PokemonTypes {
  // ノーマル
  case object NORMAL extends PokemonTypes
  // ほのお
  case object FIRE extends PokemonTypes
  // みず
  case object WATER extends PokemonTypes
  // でんき
  case object ELECTRIC extends PokemonTypes
  // くさ
  case object GRASS extends PokemonTypes
  // こおり
  case object ICE extends PokemonTypes
  // かくとう
  case object FIGHTING extends PokemonTypes
  // どく
  case object POISON extends PokemonTypes
  // じめん
  case object GROUND extends PokemonTypes
  // ひこう
  case object FLYING extends PokemonTypes
  // エスパー
  case object PSYCHIC extends PokemonTypes
  // むし
  case object BUG extends PokemonTypes
  // いわ
  case object ROCK extends PokemonTypes
  // ゴースト
  case object GHOST extends PokemonTypes
  // ドラゴン
  case object DRAGON extends PokemonTypes
  // あく
  case object DARK extends PokemonTypes
  // はがね
  case object STEEL extends PokemonTypes
  // フェアリー
  case object FAIRY extends PokemonTypes
}
