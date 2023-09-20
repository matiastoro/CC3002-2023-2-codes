package c08

object Foo {
  abstract class A(name: String)
  class B(name: String, val age: Int) extends A(name)
  class C(val name: String, override val age: Int) extends B(name, age + 10)
}

class A {
  def foo() = {}
}
class B extends A {
  // override private def foo() = {}
}

object Main {

  def bar(a: A) = {
    a.foo()
  }
  def main(args: Array[String]): Unit = {
    val a: B = new B()
    bar(a)
  }
}
