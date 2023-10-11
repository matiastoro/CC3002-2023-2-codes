package c10

object Foo {
  class E extends Exception {
    override def toString(): String = s"Excepcion E()"
  }
  class F extends Exception

  class A {
    def foo() = throw new E()
  }

  def bar() = {
    val a = new A()
    try {
      a.foo()
    } catch {
      case e: E => throw e
      case e    => println(s"capturamos un error ${e}")
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      bar()
      println("hola")
    } catch {
      case e => println("capturamos el error en el main")
    }
    println("chao")
  }

}

object Example2 {
  def foo: Int = {
    var x = 5
    try {
      println("try")
      x
    } finally {
      println("finally")
      x = 10
    }
  }

  def main(argv: Array[String]): Unit = {
    println(foo)

    // println(1+1+1)
    // -> println(2+1)
    // -> println(3)
    // ejecutar el print

  }
}

object AbortRecursion {
  class FoundException(val z: Int, val y: Int, val x: Int) extends Exception
  class Matrix3D() {
    val line0: Array[Int] = Array(0, 0, 0)
    val line1: Array[Int] = Array(1, 0, 0)
    val mat1: Array[Array[Int]] = Array[Array[Int]](line0, line0, line0)
    val mat2: Array[Array[Int]] = Array[Array[Int]](line1, line0, line0)
    val mat3: Array[Array[Int]] = Array[Array[Int]](line0, line1, line0)

    private var table = Array[Array[Array[Int]]](mat1, mat2, mat3)

    def numberOf2DMatricesWith(v: Int): Int = {
      var nbOfMatching = 0
      for (z <- 0 to table.length-1) {
        try {
          for (y <- 0 to table.length-1) {
            for (x <- 0 to table(y).length-1) {
              if (table(z)(y)(x) == v) throw new FoundException(z, y, x)
            }
          }
        } catch {
          case e: FoundException => {
            println(s"found in (${e.z},${e.y},${e.x})!")
            nbOfMatching += 1
          }
        }
      }
      nbOfMatching
    }
  }

  def main(args: Array[String]): Unit = {
    val m = new Matrix3D()
    println(m.numberOf2DMatricesWith(1))
  }

}
