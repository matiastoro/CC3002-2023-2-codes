package c09

class Stone extends Hand {
  def play(h: Hand): Int = {
    h.playWithStone(this)
  }

  def playWithStone(h: Stone): Int = 0

  def playWithPaper(h: Paper): Int = 1

  def playWithScissor(h: Scissor): Int = -1
}
