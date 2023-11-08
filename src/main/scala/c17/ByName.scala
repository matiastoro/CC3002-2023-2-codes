package c17

class ByName(name: String) extends Predicate {
  override def check(i: Item): Boolean = i.getName().equals(name)
}
