package c17.visitors
import c17._

class AbstractVisitor extends Visitor {
  override def visitGame(g: Game): Boolean = false
  override def visitComic(c: Comic): Boolean = false
  override def visitPotato(p: Potato): Boolean = false
  override def visitSeries(s: Series): Boolean = false
}
