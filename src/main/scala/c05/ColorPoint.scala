package c05

class ColorPoint(val x: Double, var y: Double) {
  private var color: Option[String] = None

  def setColor(aColor: String): Unit = {
    color = Some(aColor)
  }
  def foo(): Unit = {
    //if(color.isDefined)
    //  println(color.get.trim)

    color.map((x: String) => println(x))
  }
}

object Main{
  def main(args: Array[String]): Unit = {
    val c = new ColorPoint(1,1)
    c.setColor("Red")
    c.foo()

    println(c.x)
  }
}