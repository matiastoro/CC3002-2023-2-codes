package c15

abstract class AbstractPet[T] extends HasState[AbstractPet[T]] {
  private var state: State[AbstractPet[T]] = new Happy()

  def setState(s: State[AbstractPet[T]]) = state = s
  def doSport(): Unit = state.doSport(this)
  def giveFood(): Unit = state.giveFood(this)
  def sleep(): Unit = state.sleep(this)

  def isHappy(): Boolean = state.isHappy()
  def isHungry(): Boolean = state.isHungry()
  def isSleepy(): Boolean = state.isSleepy()
}
