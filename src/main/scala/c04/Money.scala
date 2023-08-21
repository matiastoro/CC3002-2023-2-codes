package c04

class Money(private val value: Int, private val currency: String) {
  def getValue: Int = this.value
  def getCurrency: String = this.currency

  def add(other: Money): Money = {
    // if (currency == other.currency)
    new Money(value + other.value, currency)
    // else
    //  new MoneyBag(this, other)
  }

  override def toString(): String = {
    s"Money(${value}, ${currency})"
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) { // this is wrong for now.
      val that = other.asInstanceOf[Money] // cast
      that.value == value && that.currency == currency
    } else false
  }

  /*private def canEqual(other: Any): Boolean = other.isInstanceOf[Money]

  override def equals(other: Any): Boolean = other match {
    case that: Money =>
      that.canEqual(this) &&
        value == that.value &&
        currency == that.currency
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(value, currency)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }*/
}

/*
class Foo{
  def bar(x: Money) = {
    x.value // ouch!
  }
}*/
