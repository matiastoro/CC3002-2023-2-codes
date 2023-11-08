package c17

class And(l: Predicate, r: Predicate) extends Predicate {
  override def check(i: Item): Boolean = l.check(i) && r.check(i)
}
