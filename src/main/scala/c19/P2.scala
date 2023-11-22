package c19

object P2 {
  trait MyFun[-D, +C] {
    def apply(x: D): C
  }

  class SumaUno extends MyFun[Int, Int] {
    override def apply(x: Int): Int = x + 1
  }

  class Reciproco extends MyFun[Int, Double] {
    override def apply(x: Int): Double = {
      if (x == 0) {
        throw new Error("division of zero")
      } else 1.0 / x
    }
  }

  def foo(f: MyFun[Any, Double]) = {
    f.apply("hola")
  }

  def compose[A,B,C](x: A, f: MyFun[A,B], g: MyFun[B, C]) = {
    g(f(x))
  }


  def main(args: Array[String]): Unit = {
    val f = new Reciproco()
    println(f.apply(2))

    //dado que Int<:Any, entonces MyFun[Int, Double] <: MyFun[Any, Double]
    //foo(new Reciproco())

    compose(10, new SumaUno, new Reciproco) // (1/(10+1))
  }



}
