package c17

abstract class AbstractItem(name: String, year: Int) extends Item {
  def getName(): String = name
  def getYear(): Int = year

  override def equals(obj: Any): Boolean = {
    if (obj.getClass.equals(this.getClass)) {
      val x = obj.asInstanceOf[AbstractItem]
      x.getName() == getName() && x.getYear() == getYear()
    } else false
  }
}
