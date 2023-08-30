package c05

trait Tree {
  def sum: Int
  def min: Int
  def max: Int
}

class Node(value: Int, left: Tree, right: Tree) extends Tree {
  def this(value: Int, left: Tree) = {
    this(value, left, new Nleaf())
  }
  def sum: Int = value + left.sum + right.sum
  def min: Int = math.min(value, math.min(left.min, right.min))
  def max: Int = math.max(value, math.max(left.max, right.max))
}

class Leaf(value: Int) extends Tree {
  def sum: Int = value
  def min: Int = value
  def max: Int = value
}

class Nleaf() extends Tree {
  def sum: Int = 0
  def min: Int = Integer.MAX_VALUE
  def max: Int = 0
}

//Leaf <: Tree
//Node <: Tree
object Main {
  def main(args: Array[String]): Unit = {

    val n = new Node(45, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(4))
    println(n.min)
    println(n.max)

    println("===========n2===============")
    val n2 = new Node(10, new Leaf(100))
    println(n2.min)
    println(n2.max)
    println(n2.sum)
  }
}
