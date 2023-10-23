package c13

object Variance {

  trait Animal {
    def talk() = println("hello")
  }

  class Dog extends Animal

  class Cat extends Animal

  class A[-T <: Animal] {
    def foo(x: T) = x.talk()
  }

  val a: A[Dog] = new A[Animal]()
  a.foo(new Dog())
  //a.foo(new Animal()) // No compila!

  class B[+T](a: T) {
    def foo: T = a
  }

  val b: B[Animal] = new B[Dog](new Dog())
  b.foo.talk()

  class C[T <: Animal](a: T) {
    def foo: T = a

    def bar(x: T) = x.talk()
  }

  //val c: C[Animal] = new C[Dog](new Dog()) // No compila!
  val c: C[Dog] = new C[Dog](new Dog())
  c.foo.talk()

}
