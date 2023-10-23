package c13

object Privacy {
  trait IUnit {
    def setHp(hp: Int): Unit

    def getHp(): Int
  }

  trait PIUnit {
    def getHp(): Int
  }

  class Player extends IUnit with PIUnit {
    var hp: Int = 100

    def setHp(hp: Int): Unit = this.hp = hp

    def getHp() = hp
  }

  class Controller {
    val player = new Player()

    def hitPlayer = player.setHp(player.hp - 10)

    def getReadOnlyCurrentPlayer(): PIUnit = player
  }

  def main(args: Array[String]): Unit = {
    val controller = new Controller()
    controller.hitPlayer
    println(controller.getReadOnlyCurrentPlayer().getHp()) // 90
    //controller.getReadOnlyCurrentPlayer().setHp(100) // No compila!
  }
}


