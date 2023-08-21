package c04

class MoneyTest extends munit.FunSuite {
  var clp10: Money = null
  var clp20: Money = null

  var usd10: Money = null
  var usd12: Money = null

  var fMB1: MoneyBag = null
  var fMB2: MoneyBag = null

  override def beforeEach(context: BeforeEach): Unit = {
    clp10 = new Money(10, "CLP")
    clp20 = new Money(20, "CLP")
    usd10 = new Money(10, "USD")
    usd12 = new Money(12, "USD")
    fMB1 = new MoneyBag(clp10, usd10)
    fMB2 = new MoneyBag(clp20, usd12)

  }

  test("equals trivial") {
    val clp10p = clp10
    assertEquals(clp10, clp10p)
    assertNotEquals(clp10, clp20)
  }
  test("equals not trivial") {
    val clp10p = new Money(10, "CLP")
    assertEquals(clp10, clp10p)
  }
  test("add moneys") {
    val expected = new Money(30, "CLP")
    assertEquals(clp10.add(clp20), expected)
  }

  test("Money toString") {
    assertEquals(clp10.toString(), "Money(10, CLP)")
  }

  test("equals") {
    assertEquals(fMB1, fMB1)
    assert(!fMB1.equals(clp10))
    assert(!clp10.equals(fMB1))
    assert(!fMB1.equals(fMB2))
  }

  test("Moneybag add") {
    val mb = new MoneyBag()
    mb.addMoney(clp10)
    mb.addMoney(clp20)
    val clp30 = Some(new Money(30, "CLP"))
    assertEquals(mb.getMoneyAt("CLP"), clp30)
  }

  test("mixed simple add") {
    val expected: MoneyBag = new MoneyBag(clp10, usd10)
    // assertEquals(expected, clp10.add(usd10))// :( no se puede por ahora
  }

}
