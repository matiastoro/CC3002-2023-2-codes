package c09

trait Hand {
  def play(h: Hand): Int
  def playWithStone(h: Stone): Int
  def playWithPaper(h: Paper): Int
  def playWithScissor(h: Scissor): Int
}
