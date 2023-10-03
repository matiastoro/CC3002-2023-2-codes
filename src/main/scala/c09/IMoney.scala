package c09

trait IMoney {
  def add(m: IMoney): IMoney

  def addMoney(m: Money): IMoney

  def addMoneyBag(m: MoneyBag): IMoney
}
