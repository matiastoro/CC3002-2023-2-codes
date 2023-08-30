package c05

trait MyList {
  def insert(v: Any, i: Int): Unit
  def get(i: Int): Any
  def search(v: Any): Int
  def searchAll(v: Any): List[Int]
  def exists(v: Any): Boolean
  def searchWeird(v: Any): Any
}
