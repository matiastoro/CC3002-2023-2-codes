package c11

object Generics {
  // forall X. X -> X
  def process[T](o: T): T = {
    o
  }

  process[Int](6) // 6
  process[String]("hola") // "hola"

  def swap[X, Y](p: (X, Y)): (Y, X) = (p._2, p._1)

  // swap[String, Int]((1, "hola")) // No compila
  swap[Int, String]((1, "hola")) // ("hola", 1)
  swap((1, "hola")) // ("hola", 1)

}
