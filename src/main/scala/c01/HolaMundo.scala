package c01

object HolaMundo {

  def hailstone(n: Int): List[Int] = {
    n :: (if(n==1)
      List()
    else if(n%2 == 0)
      hailstone(n/2)
    else
      hailstone(3*n+1))
  }

  def foo() = {
    10
  }

  def main(args: Array[String]): Unit  = {
    println("hello world")
    println(hailstone(5))
  }
}