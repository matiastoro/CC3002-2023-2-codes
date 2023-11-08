package c16

object TombRaider {
  trait Ammo
  class Bullet extends Ammo
  class Arrow extends Ammo
  class Stone extends Ammo
  class Granade extends Ammo

  trait Factory {
    def create(): Ammo
  }
  class BulletFactory extends Factory {
    def create() = {
      println("bang!")
      new Bullet()
    }
  }

  class StoneFactory extends Factory {
    def create() = {
      println("bonk!")
      new Bullet()
    }
  }

  class GranadeFactory extends Factory {
    def create() = {
      println("boom!")
      new Bullet()
    }
  }
  class Lara {
    var factory: Factory = new BulletFactory()
    def shoot(): Ammo = factory.create()
    def setFactory(f: Factory) = factory = f
  }
  def main(args: Array[String]): Unit = {
    val lara = new Lara()
    lara.shoot()
    lara.setFactory(new StoneFactory())
    lara.shoot()
    lara.setFactory(new GranadeFactory())
    lara.shoot()
    println(new Foo().Bar)
  }

  abstract class Lere {
    private var ammoFactory: Factory = null

    def setAmmoFactory(f: Factory): Unit = {
      ammoFactory = f
    }
  }
  object Liri extends Lere {
    setAmmoFactory(new BulletFactory())
  }

  object Loro extends Lere {}

  class Foo {
    object Bar
  }

}
