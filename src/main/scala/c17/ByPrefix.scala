package c17

class ByPrefix(prefix: String) extends Predicate {
  override def check(i: Item): Boolean = i.getName().startsWith(prefix)
}
