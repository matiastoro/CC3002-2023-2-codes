package c17
import scala.collection.mutable.Set

class Library {
  private val item: Set[Item] = Set()
  def add(i: Item): Unit = {
    item += i
  }
  def isEmpty(): Boolean = item.isEmpty

  def searchByPredicate(p: Predicate): Set[Item] = {
    item.filter(i => p.check(i))
  }
}

/*val aux = Set()
    for(i <- item){
      if(i.getName() == name)
        aux += i
    }
    aux*/
