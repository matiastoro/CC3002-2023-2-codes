package c12

object Exercise2 {

  trait Option[+T] {
    def get: T
    def isEmpty: Boolean
    def getOrElse[S >: T](y: S): S
  }

  class Some[T](x: T) extends Option[T] {
    def get: T = x
    def isEmpty: Boolean = false
    def getOrElse[S >: T](y: S) = x
  }

  object None extends Option[Nothing] {
    def get: Nothing = throw new Exception("None.get")
    def isEmpty: Boolean = true
    def getOrElse[S >: Nothing](y: S): S = y
  }

  def main(args: Array[String]): Unit = {
    val foo: Option[String] = new Some[String]("hola")
    val bar: Option[String] = None
    println(foo.getOrElse(new Object()))
    println(bar.getOrElse("Chao"))
  }
}
