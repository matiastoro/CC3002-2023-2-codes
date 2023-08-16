package c03

object Operaciones {
  def abs(x: Int): Int = if(x<0) -x else x

  def times(x: Int, y: Int): Int = x*y

  def add1(x: Int): Int = x+1

  def myTest(nombre: String)(e: Any) = {
    println(e)
    println(e)
  }
  def main(args: Array[String]): Unit = {
    /*myTest("hola")({
      println("chao")
      1
    })*/



    val l: List[Int] = List(1,2,3,4,5,6)
    val lp: List[Int] = List()
    println(lp.headOption)

    val x: Option[String] = None
    val y: Option[String] = Some("hola")

    if(x.isDefined)
      x.get.trim

    val z: MaybeInt = new Nada()
    val w: MaybeInt = new Algo(42)

    if(w.isDefined)
      w.get + 1

    val m: Map[String, String] = Map[String, String](
      "hola" -> "hello",
      "chao" -> "goodbye"
    )


    m.get("hola").map(x => println(x.trim()))




  }

  def foo(x: Option[Int], y: Int) = {
    x.getOrElse(0) + y
  }
}


trait MaybeInt{
  def get: Int
  def isDefined: Boolean
}

class Nada extends MaybeInt {
  def get: Int = throw new Error("getting something from Nada")

  def isDefined: Boolean = false
}

class Algo(x: Int) extends MaybeInt {
  def get: Int = x

  def isDefined: Boolean = true
}


