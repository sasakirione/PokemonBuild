package domain.value

class PokemonBaseValue (val hp: Int, val attack: Int, val defense: Int, val spAttack: Int, val spDefense: Int, val speed: Int) {
  hp match {
    case x if x < 0 => throw new IllegalArgumentException("hp must be greater than 0")
    case _ =>
  }
  attack match {
    case x if x < 0 => throw new IllegalArgumentException("attack must be greater than 0")
    case _ =>
  }
  defense match {
    case x if x < 0 => throw new IllegalArgumentException("defense must be greater than 0")
    case _ =>
  }
  spAttack match {
    case x if x < 0 => throw new IllegalArgumentException("spAttack must be greater than 0")
    case _ =>
  }
  spDefense match {
    case x if x < 0 => throw new IllegalArgumentException("spDefense must be greater than 0")
    case _ =>
  }
  speed match {
    case x if x < 0 => throw new IllegalArgumentException("speed must be greater than 0")
    case _ =>
  }
}
