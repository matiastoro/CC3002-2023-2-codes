package c17.visitors
import c17.{Comic, Game, Potato, Series}

object GameVisitor extends AbstractVisitor {
  override def visitGame(g: Game): Boolean = true
}
