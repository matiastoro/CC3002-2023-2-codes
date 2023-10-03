package c09

class Paper extends Hand {
  def play(h: Hand): Int = {
    h.playWithPaper(this)
  }

  def playWithStone(h: Stone): Int = -1

  def playWithPaper(h: Paper): Int = 0

  def playWithScissor(h: Scissor): Int = 1
}
