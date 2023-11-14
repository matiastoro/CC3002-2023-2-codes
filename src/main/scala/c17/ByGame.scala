package c17

import c17.visitors.GameVisitor

class ByGame extends Predicate {
  override def check(i: Item): Boolean = i.accept(GameVisitor)
}
