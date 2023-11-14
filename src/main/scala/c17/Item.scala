package c17

import c17.visitors.Visitor

trait Item {
  def getName(): String
  def getYear(): Int

  def accept(v: Visitor): Boolean
}
