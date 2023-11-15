package c18
object OOP {
  trait Exp {
    def eval: Int
    def pprint: String
  }
  case class Lit(n: Int) extends Exp {
    def eval: Int = n
    def pprint: String = n.toString
  }
  // Lit(1).eval ==> 1

  case class Sum(e1: Exp, e2: Exp) extends Exp {
    def eval: Int = e1.eval + e2.eval
    def pprint: String = s"(${e1.pprint} + ${e2.pprint})"
  }
  // modificar arriba: costoso. Modificar abajo: ggez

  case class Sub(e1: Exp, e2: Exp) extends Exp {
    def eval: Int = e1.eval - e2.eval
    def pprint: String = s"(${e1.pprint} - ${e2.pprint})"
  }

  def main(args: Array[String]): Unit = {
    // 1 + (9 - (3+2))
    val e = Sum(Lit(1), Sub(Lit(9), Sum(Lit(3), Lit(2))))
    println(e.eval)
    println(e.pprint)
  }

}

object FP {
  trait Exp
  case class Lit(n: Int) extends Exp
  case class Sum(e1: Exp, e2: Exp) extends Exp

  def eval(e: Exp): Int = {
    e match {
      case Lit(n)      => n
      case Sum(e1, e2) => eval(e1) + eval(e2)
      case Sub(e1, e2) => eval(e1) - eval(e2)
    }
  }

  // modificar arriba: costoso. Modificar abajo: ggez

  def pprint(e: Exp): String = {
    e match {
      case Lit(n)      => n.toString
      case Sum(e1, e2) => s"(${pprint(e1)} + ${pprint(e2)})"
      case Sub(e1, e2) => s"(${pprint(e1)} - ${pprint(e2)})"
    }
  }

  case class Sub(e1: Exp, e2: Exp) extends Exp

  def main(args: Array[String]): Unit = {
    // 1 + (9 - (3+2))
    val e = Sum(Lit(1), Sub(Lit(9), Sum(Lit(3), Lit(2))))
    println(eval(e))
    println(pprint(e))
  }

}

object EPOneSolution {
  trait Exp {
    def eval: Int
  }
  trait Lit extends Exp {
    val n: Int
    def eval = n
  }
  trait Sum extends Exp {
    val e1: Exp
    val e2: Exp
    override def eval = e1.eval + e2.eval
  }
  // modificar arriba: costoso. Modificar abajo: ggez

  trait Sub extends Exp {
    val e1: Exp
    val e2: Exp
    override def eval = e1.eval - e2.eval
  }
  trait PrintExp extends Exp {
    def pprint: String
  }
  trait PrintLit extends Lit with PrintExp {
    def pprint = n.toString
  }
  trait PrintSum extends Sum with PrintExp {
    val e1: PrintExp
    val e2: PrintExp
    def pprint = s"(${e1.pprint} + ${e2.pprint})"
  }
  trait PrintSub extends Sub with PrintExp {
    val e1: PrintExp
    val e2: PrintExp
    def pprint = s"(${e1.pprint} - ${e2.pprint})"
  }

  // modificar arriba: L. Modificar abajo: W

  trait CountExp extends Exp {
    def count: Int
  }
  trait CountLit extends Lit with CountExp {
    def count = 1
  }
  trait CountSum extends Sum with CountExp {
    val e1: CountExp
    val e2: CountExp
    def count = e1.count + e2.count
  }

  trait CountSub extends Sub with CountExp {
    val e1: CountExp
    val e2: CountExp
    def count = e1.count + e2.count
  }

  // modificar arriba: L. Modificar abajo: W

  trait CPExp extends CountExp with PrintExp
  trait CPLit extends CountLit with PrintLit with CPExp
  trait CPSum extends CountSum with PrintSum with CPExp {
    val e1: CPExp
    val e2: CPExp
  }
  trait CPSub extends CountSub with PrintSub with CPExp {
    val e1: CPExp
    val e2: CPExp
  }

  def main(args: Array[String]): Unit = {
    val x = new CPLit { val n = 1 }
    val s = new CPSum {
      val e1 = x
      val e2 = new CPLit { val n = 3 }
    }
    println(s.eval)
    println(s.count)
    println(s.pprint)
  }
}
