package c17.visitors

import c17.Comic

object ComicVisitor extends AbstractVisitor {
  override def visitComic(g: Comic): Boolean = true
}
