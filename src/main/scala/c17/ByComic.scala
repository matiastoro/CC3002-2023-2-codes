package c17

import c17.visitors.ComicVisitor

class ByComic extends Predicate {
  override def check(i: Item): Boolean = i.accept(ComicVisitor)
}
