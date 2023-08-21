package c04
import scala.collection.mutable.Map
class MoneyBag {
  val moneys: Map[String, Money] = Map()

  def this(m1: Money, m2: Money) = {
    this()
    addMoney(m1)
    addMoney(m2)
  }

  def addMoney(m: Money): Unit = {
    val newMoney =
      if (moneys.isDefinedAt(m.getCurrency)) {
        val oldMoneyOptional: Option[Money] = moneys.get(m.getCurrency)
        val oldMoney: Money = oldMoneyOptional.get
        oldMoney.add(m)
      } else
        m
    // moneys[m.getCurrency] = newMoney
    moneys += (m.getCurrency -> newMoney)

  }

  def getMoneyAt(currency: String): Option[Money] = {
    moneys.get(currency)
  }

}
