package c15

trait HasState[T] {
  def setState(s: State[T]): Unit
}
