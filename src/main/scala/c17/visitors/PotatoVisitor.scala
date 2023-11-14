package c17.visitors

import c17.Potato

class PotatoVisitor extends AbstractVisitor {
  override def visitPotato(g: Potato): Boolean = true
}
