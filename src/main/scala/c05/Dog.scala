package c05


trait HasLegs{
  val numLegs: Int
  def walk(): Unit
}

trait HasTail{
  def tailColor: String
}

trait Dog extends HasLegs with HasTail

class IrishSetter extends Dog{
  val numLegs = 4
  def walk() = println("I'm walking woof")
  def tailColor = "Red"
}

class AlienDog extends Dog{
  val numLegs = 5
  def walk() = println("bzzz")
  def tailColor = "Blue"
}
object Main2{
  def foo(x: Dog): Unit = {
    x.walk()
    x.tailColor
  }
  // IrishSetter <: Dog
  // Dog <: HasLegs
  // Dog <: HasTail
  // => por transitividad
  // IrishSetter <: HasLegs
  // IrishSetter <: HasTail
  val dog: HasTail = new IrishSetter
  foo(new IrishSetter)
  foo(new AlienDog)


  // AlienDog <: Dog <: HasLegs
  def bar(x: HasLegs): Unit = {
    println(x.numLegs)
  }
  val dogo: AlienDog = new AlienDog
  //bar(dogo) //compila!
  val dogo2: HasTail = new AlienDog
  //HasTail </: HasTail
  //bar(dogo2) // no compila



  class A(name: String = "Juan") {
    def this() = {
      this("Maria")
      println("constructor auxiliar")
    }
  }

  def main(args: Array[String]): Unit = {
    new A()
  }




}




