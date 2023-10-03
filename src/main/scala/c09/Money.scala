package c09

class Money(private val value: Int, private val currency: String)
    extends IMoney {
  def getValue: Int = this.value
  def getCurrency: String = this.currency

  override def toString(): String = {
    s"Money(${value}, ${currency})"
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) { // this is wrong for now.
      val that = other.asInstanceOf[Money] // cast
      that.value == value && that.currency == currency
    } else false
  }

  def add(m: IMoney): IMoney = {
    // No sabemos si m es un Money, o un MoneyBag. Como nos sumamos?
    m.addMoney(this)
  }

  def addMoneySameCurrency(money: Money): Money = {
    assert(this.currency == money.currency)
    new Money(value + money.value, currency)
  }
  def addMoney(m: Money): IMoney = {
    if (currency == m.currency)
      addMoneySameCurrency(m)
    else
      new MoneyBag(this, m)
  }

  def addMoneyBag(m: MoneyBag): IMoney = {
    m.addMoney(this)
  }
}
