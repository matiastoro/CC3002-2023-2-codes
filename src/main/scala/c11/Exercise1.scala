package c11

object Exercise1 {
  class Tuple[L, R](l: L, r: R) {
    def _1: L = l
    def _2: R = r
  }

  def main(args: Array[String]): Unit = {
    val t = new Tuple[Int, String](1, "hola")
    println(t._1 + 1)
    // println(t._2 / 2)

  }

}
