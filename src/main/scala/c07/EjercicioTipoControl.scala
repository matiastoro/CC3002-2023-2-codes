package c07

object EjercicioTipoControl {
  abstract class A(name: String, age: Int) {
    println(s"A, name:${name}, age: ${age}")

  }
  class B(name: String) extends A(name, 10) {
    println("B")
    def this(name: String, age: Int) = {
      this(name)
      println("B2")
    }
    def foo() = 2
  }
  class C extends B("Foo") {
    println("C")
    override def foo() = 3
  }

  def bar(c: B) = {
    c.foo() // dynamic dispatch!!
  }
  def main(args: Array[String]): Unit = {
    // val a: A = new C()
    // val b: A = new B("John")
    // b.foo() // no compila

    val c: B = new C()
    bar(new C())

    val b: B = new B("John", 30)
  }

}
