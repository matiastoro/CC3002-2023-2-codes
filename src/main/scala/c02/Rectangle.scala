package c02

class Rectangle(private var point: Point,
                private var width: Double,
                private var height: Double
               ) extends Movable{
  def move(dx: Double, dy: Double): Unit = {
    point.move(dx,dy)
  }

  def area() = {
    width * height
  }

  def getOrigen: Point = point

  def foo(x: Boolean): Boolean = x
}
