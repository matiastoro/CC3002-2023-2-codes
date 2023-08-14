package c02

object Main{
  def main(args: Array[String]): Unit = {
    val p1: Point = new Point(0,0)
    val p2: Point = new Point(0,0)
    println(p1)


    val r = new Rectangle(p1, 10, 100)

    p1.move(1.0, 5.0)
    println(p1)

    println(s"el area del rectangulo es ${r.area}")
    println(s"el origen del rectangulo es ${r.getOrigen}")

    println(p2 == r.getOrigen)
  }
}
