package c17

class Or(l: Predicate, r: Predicate) extends Predicate {
  override def check(i: Item): Boolean = l.check(i) || r.check(i)
}
