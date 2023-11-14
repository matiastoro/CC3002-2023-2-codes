package c17.visitors

import c17._

trait Visitor {
  // domain: Game, Comic, Potato, Serie
  def visitGame(g: Game): Boolean
  def visitComic(c: Comic): Boolean
  def visitPotato(p: Potato): Boolean
  def visitSeries(s: Series): Boolean
}
