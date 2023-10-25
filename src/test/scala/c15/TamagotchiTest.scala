package c15

class TamagotchiTest extends munit.FunSuite {
  test("is Happy?") {
    val t = new Tamagotchi()
    assert(t.isHappy())
  }

  test("doSport") {
    val t = new Tamagotchi()
    t.doSport()
    assert(!t.isHappy())
    assert(t.isHungry())
  }
  test("giveFood") {
    val t = new Tamagotchi()
    t.doSport()
    t.giveFood()
    assert(!t.isHappy())
    assert(!t.isHungry())
    assert(t.isSleepy())
  }
  test("sleep") {
    val t = new Tamagotchi()
    t.doSport()
    t.giveFood()
    t.sleep()
    assert(t.isHappy())
    assert(!t.isHungry())
    assert(!t.isSleepy())
  }
  test("dogo sleepo") {
    val t = new Dog()
    t.doSport()
    t.giveFood()
    t.sleep()
    assert(t.isHappy())
    assert(!t.isHungry())
    assert(!t.isSleepy())
  }
}
