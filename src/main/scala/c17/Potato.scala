package c17

import c17.visitors.Visitor

class Potato(year: Int) extends AbstractItem("papa", year) {
  override def accept(v: Visitor): Boolean = v.visitPotato(this)
}
