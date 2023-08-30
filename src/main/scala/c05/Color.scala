package c05

trait PrintColor{
  def print(): Unit
}
trait RainbowColor{
  def rainbow(): Int
}

trait LotsOfColors extends PrintColor with RainbowColor{
  def foo(): String
}

class Color extends LotsOfColors{
  def print(): Unit = println("soy un color")
  def rainbow(): Int = 10
  def foo(): String = "hola"
}
