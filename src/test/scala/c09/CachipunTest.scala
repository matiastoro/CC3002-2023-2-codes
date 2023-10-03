package c09

import munit.FunSuite

class CachipunTest extends FunSuite{
  val stone = new Stone()
  val paper = new Paper()
  val scissor = new Scissor()

  test("piedra"){
    assertEquals(0, stone.play(stone))
    assertEquals(-1, stone.play(paper))
    assertEquals(1, stone.play(scissor))
  }
}
