package c17

class Neg(p: Predicate) extends Predicate {
  override def check(i: Item): Boolean = !p.check(i)
}
