package c17
import scala.collection.mutable.Set

class LibraryTest extends munit.FunSuite {
  var l: Library = _
  var s1: Series = new Series("The Walking Dead", 2010)
  val g1: Game = new Game("Tomb Raider", 2002)
  val c1: Comic = new Comic("The Walking Dead", 2000)
  val p1: Potato = new Potato(2023)

  override def beforeEach(context: BeforeEach): Unit = {
    l = new Library()
  }

  test("empty Library") {
    assert(l.isEmpty())
  }
  test("non empty Library") {
    l.add(s1)
    l.add(g1)
    assert(!l.isEmpty())
  }
  test("search by name") {
    l.add(s1)
    l.add(g1)
    val expected: Set[Item] = Set(new Series("The Walking Dead", 2010))

    assertEquals(
      l.searchByPredicate(new ByName(s1.getName())).toSet,
      expected.toSet,
      "Testing with 'equal' object"
    )

    val expected2: Set[Item] = Set(s1)
    assertEquals(
      l.searchByPredicate(new ByName(s1.getName())),
      expected2,
      "Testing with the same object"
    )
  }
  test("search by name not found") {
    l.add(s1)
    l.add(g1)
    assertEquals(l.searchByPredicate(new ByName("Baki")), Set[Item]())
  }

  test("search by name multiple items") {
    l.add(s1)
    l.add(g1)
    l.add(c1)
    assertEquals(
      l.searchByPredicate(new ByName("The Walking Dead")),
      Set[Item](s1, c1)
    )
  }

  test("search by year") {
    l.add(s1)
    l.add(g1)
    l.add(c1)
    assertEquals(l.searchByPredicate(new ByYear(2010)), Set[Item](s1))
  }

  test("search by prefix") {
    l.add(s1)
    l.add(g1)
    l.add(c1)
    assertEquals(l.searchByPredicate(new ByPrefix("Tomb")), Set[Item](g1))
  }

  test("search by and") {
    l.add(s1)
    l.add(g1)
    l.add(c1)
    val result = l.searchByPredicate(
      new And(
        new ByName("The Walking Dead"),
        new ByYear(2000)
      )
    )
    val expected = Set[Item](c1)
    assertEquals(result, expected)
  }

  test("search by or") {
    l.add(s1)
    l.add(g1)
    l.add(c1)
    l.add(p1)
    val result = l.searchByPredicate(
      new Or(
        new ByPrefix("Tomb"),
        new ByYear(2010)
      )
    )
    val expected = Set[Item](s1, g1)
    assertEquals(result, expected)
  }

  test("negation") {
    l.add(s1)
    l.add(g1)
    l.add(c1)
    l.add(p1)
    val result = l.searchByPredicate(
      new Neg(
        new Or(
          new ByYear(2010),
          new ByYear(2002)
        )
      )
    )
    val expected = Set[Item](c1, p1)
    assertEquals(result, expected)
  }

  test("byGame") {
    l.add(s1)
    l.add(g1)
    l.add(c1)
    l.add(p1)
    val result = l.searchByPredicate(
      new Or(
        new ByGame(),
        new ByComic()
      )
    )
    val expected = Set[Item](g1, c1)
    assertEquals(result, expected)
  }
}
