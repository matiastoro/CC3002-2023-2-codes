package c15

class WrongStateException extends Exception("Wrong State!")

trait State[T] {
  def doSport(t: T): Unit
  def giveFood(t: T): Unit
  def sleep(t: T): Unit

  def isHappy(): Boolean
  def isHungry(): Boolean
  def isSleepy(): Boolean
}
abstract class AbstractState[T <: HasState[T]] extends State[T] {
  def error = throw new WrongStateException()

  def doSport(t: T): Unit = error
  def giveFood(t: T): Unit = error
  def sleep(t: T): Unit = error

  def isHappy(): Boolean = false
  def isHungry(): Boolean = false
  def isSleepy(): Boolean = false

  protected def changeState(t: T, s: State[T]) = t.setState(s)
}
class Happy[T <: HasState[T]] extends AbstractState[T] {
  override def doSport(t: T): Unit =
    changeState(t, new Hungry())
  override def isHappy() = true
}

class Hungry[T <: HasState[T]] extends AbstractState[T] {
  override def giveFood(t: T): Unit =
    changeState(t, new Sleepy())
  override def isHungry() = true
}
class Sleepy[T <: HasState[T]] extends AbstractState[T] {
  override def sleep(t: T): Unit =
    changeState(t, new Happy())
  override def isSleepy() = true
}
