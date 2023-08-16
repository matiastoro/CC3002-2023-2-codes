package c03

class OperacionesTest extends munit.FunSuite {



  test("suma 1"){
    assertEquals(Operaciones.add1(1), 2)
    assertEquals(Operaciones.add1(2), 3)
  }
  test("times"){
    assertEquals(Operaciones.times(3,5), 15)
  }
  test("abs"){
    assertEquals(Operaciones.abs(17), 17)
    assertEquals(Operaciones.abs(-3), 3)

  }
}
