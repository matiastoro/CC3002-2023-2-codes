package c06

trait A {
  def foo(): String
}
trait B extends A {
  def lala(): Int = 1
}

abstract class Foo extends B {
  def foo() = bluelabel()
  def bluelabel(): String
}
class Bar extends Foo {
  def bluelabel(): String = "un elissir"
}

object Foo {
  val b: Bar = new Bar()
  b.bluelabel()
  import scala.collection.mutable.ListBuffer
  def main(args: Array[String]): Unit = {
    val l = ListBuffer(1, 2, 3)
    l += 4 // ListBuffer(1,2,3,4)
    println(l)
  }
}

class X {
  def foo() = {
    1 + 2
  }
}
