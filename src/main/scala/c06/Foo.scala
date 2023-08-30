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

object Main {
  val b: Bar = new Bar()
  b.bluelabel()
}
