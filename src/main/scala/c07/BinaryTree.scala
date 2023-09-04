package c07

trait Comparable[T] {
  def compareTo(el: T): Int
}
//(new Leaf(1)).compareTo(new Leaf(3)) ---> -1
trait Tree extends Comparable[Tree] {
  def sum: Int
}
abstract class AbstractTree extends Tree {
  def compareTo(el: Tree): Int = sum.compareTo(el.sum)
}
class Node(value: Int, left: Tree, right: Tree) extends AbstractTree {
  def sum: Int = value + left.sum + right.sum
}
class Leaf(value: Int) extends AbstractTree {
  def sum: Int = value
}
class Nleaf() extends AbstractTree {
  def sum: Int = 0
}

object Main {
  def foo[T](el: Comparable[T]) = {
    // ..
    // el.compareTo(el)
  }
}
