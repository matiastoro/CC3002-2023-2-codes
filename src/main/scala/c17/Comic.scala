package c17
import c17.visitors.Visitor

class Comic(name: String, year: Int) extends AbstractItem(name, year) {
  override def accept(v: Visitor): Boolean = v.visitComic(this)
}
