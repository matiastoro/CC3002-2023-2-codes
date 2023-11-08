package c17

class ByYear(year: Int) extends Predicate {
  override def check(i: Item): Boolean = i.getYear() == year
}
