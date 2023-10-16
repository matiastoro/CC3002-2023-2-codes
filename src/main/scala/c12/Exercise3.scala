package c12

object Exercise3 {
  trait Comparable[T] {
    // 1 si somos mayores
    // -1 si somos menores
    // 0 si somos iguales
    def compareTo(other: T): Int
  }

  trait Tree[T <: Comparable[T]] {
    def find(el: T): Boolean
    def max: T
  }

  class Leaf[T <: Comparable[T]](value: T) extends Tree[T] {
    def find(el: T): Boolean = value.compareTo(el) == 0
    def max: T = value
  }
  class Node[T <: Comparable[T]](left: Tree[T], right: Tree[T])
      extends Tree[T] {
    def find(el: T): Boolean = left.find(el) || right.find(el)
    def max = {
      val maxLeft = left.max
      val maxRight = right.max
      if (maxLeft.compareTo(maxRight) > 0) maxLeft
      else maxRight
    }
  }

  case class Person(name: String) extends Comparable[Person] {
    def compareTo(other: Person): Int = name.compareTo(other.name)
  }

  def main(args: Array[String]): Unit = {
    val t = new Node[Person](
      new Node(
        new Node(
          new Leaf(new Person("Foo")),
          new Leaf(new Person("Bar"))
        ),
        new Leaf(new Person("Baz"))
      ),
      new Leaf(new Person("Juan"))
    )



    println(s"Juan está? ${t.find(new Person("Juan"))}") // true
    println(s"María está? ${t.find(new Person("Maria"))}") // false
    println(s"El máximo es ${t.max}")
  }

}
