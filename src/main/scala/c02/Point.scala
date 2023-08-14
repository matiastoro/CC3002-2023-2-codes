package c02



class Point(private var x: Double,
            private var y: Double) extends Movable{
  def move(dx: Double, dy: Double): Unit = {
    x = x + dx
    y = y + dy
  }
  override def toString: String = {
    s"Point(${x}, ${y})"
  }
}
