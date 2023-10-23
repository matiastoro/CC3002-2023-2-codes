package c14

import scala.collection.mutable.ListBuffer

object Observer {
  trait ISubject[T] {
    def registerObserver(o: Observer[T]): Unit
    def notifyObservers(event: T): Unit
  }
  abstract class Subject[T] extends ISubject[T] {
    private val observers: ListBuffer[Observer[T]] = ListBuffer()
    def registerObserver(o: Observer[T]): Unit = observers += o

    def notifyObservers(event: T): Unit = {
      observers.foreach(_.update(this, event))
    }
  }
  trait Observer[T] {
    def update(s: ISubject[T], event: T)
  }
  class ConcreteSubject extends Subject[Notification] {
    def foo() = {
      notifyObservers(new Notification("hoy", 1, 42.0))
    }
  }
  class ConcreteObserver extends Observer[Notification] {
    def update(s: ISubject[Notification], event: Notification) = {
      println(s"Recibi un string: ${event}")
    }
  }

  case class Notification(date: String, foo: Int, bar: Double)

  def main(args: Array[String]): Unit = {
    val subject = new ConcreteSubject()
    val observer = new ConcreteObserver()
    subject.registerObserver(observer)

    subject.foo()
  }
}
