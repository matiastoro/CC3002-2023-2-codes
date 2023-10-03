package c09

import scala.collection.mutable.Map
class MoneyBag extends IMoney {
  private val moneys: Map[String, Money] = Map()

  def this(m1: Money, m2: Money) = {
    this()
    addMoney(m1)
    addMoney(m2)
  }

  // T1 -> T2 <: T3 -> T4 ssi T3 <: T1 and T2 <: T4
  override def add(m: IMoney): IMoney = {
    m.addMoneyBag(this)
  }

  def addMoney(m: Money): IMoney = {
    val newMoney =
      if (moneys.isDefinedAt(m.getCurrency)) {
        val oldMoney: Money = moneys.get(m.getCurrency).get
        oldMoney.addMoneySameCurrency(m)
      } else {
        m
      }
    moneys += (m.getCurrency -> newMoney)
    this
  }

  def getMoneyAt(currency: String): Option[Money] = {
    moneys.get(currency)
  }

  def addMoneyBag(m: MoneyBag): IMoney = {
    for { (_, v) <- m.moneys } {
      addMoney(v)
    }
    this
  }

  private def canEqual(other: Any): Boolean = other.isInstanceOf[MoneyBag]

  override def equals(other: Any): Boolean = other match {
    case that: MoneyBag =>
      that.canEqual(this) &&
      moneys == that.moneys
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(moneys)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
