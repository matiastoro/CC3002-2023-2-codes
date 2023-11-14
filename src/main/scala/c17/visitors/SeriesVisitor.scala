package c17.visitors

import c17.Series

object SeriesVisitor extends AbstractVisitor {
  override def visitSeries(g: Series): Boolean = true
}
