package c09

class Scissor extends Hand {
  def play(h: Hand): Int = {
    h.playWithScissor(this)
  }

  def playWithStone(h: Stone): Int = 1

  def playWithPaper(h: Paper): Int = -1

  def playWithScissor(h: Scissor): Int = 0
}
