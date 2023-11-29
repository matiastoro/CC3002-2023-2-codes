package c20

object FP {
  def main(args: Array[String]): Unit = {
    // Capitalize the first letter of each word in a sentence
    def capitalize(l: List[String]): List[String] = {
      l.map(sentence =>
        sentence
          .split(" ")
          .map(word => word.capitalize)
          .mkString(" ")
      )
    }
    println(capitalize(List("hello world", "goodbye world")))
    // retornar: List("Hello World", "Goodbye World")
    // funcion de ayuda "hello world".capitalize -> "Hello world"
    // List("hola", "chao", "pescao").mkString("_") -> "hola_chao_pescao"

    // Write a function that takes a list of sentences, split them into words
    // and returns a Map with the count of each word.
    def wordCount(l: List[String]): Map[String, Int] = {
      l.flatMap(sentence => sentence.split(" "))
        .foldLeft(Map[String, Int]()) { (acc, word) =>
          acc + (word -> (acc.getOrElse(word, 0) + 1))
        }
    }
    println(wordCount(List("hello world", "goodbye world")))
    // return: Map("hello" -> 1, "world" -> 2, "goodbye" -> 1)
    // para extender un map m, se puede hacer:  m + ("llave" -> 1)
    // para acceder al valor de una llave: m("llave") o m.getOrElse("llave", default)

    // Escriba una funcion que tome dos listas y retorne una nueva lista con los elementos
    // en común
    def commonElements[T](l1: List[T], l2: List[T]): List[T] = {
      l1.filter(x => l2.contains(x))
    }
    println(commonElements[Int](List[Int](1, 2, 3, 4), List[Int](3, 4, 5, 6)))
    // deberia imprimir: List[Int](3,4)
    // pueden ocupar contains: l.contains(1) => devuelve true si 1 pertenece a la lista l

    // Escriba una funcion que calcule el producto punto
    // entre dos vectores representados por listas de integers.
    def dotProduct(l1: List[Int], l2: List[Int]): Int = {
      l1.zip(l2).foldLeft(0)((acc, p) => acc + p._1 * p._2)
      l1.zip(l2).map(p => p._1 * p._2).sum
      l1.zip(l2).map(p => p._1 * p._2).foldLeft(0)((acc, m) => acc + m)
    }

    println(dotProduct(List(1, 2, 3), List(4, 5, 6)))
    // List((1,4), (2,5), (3,6))
    // reduce a 1*4 + 2*5 + 3*6 = 32
    // Si tienen el par val x = (12,26), accedemos al primer elemento: x._1
    // y al segundo x._2

    // Escriba una funcion que filtre una lista de valores opcionales
    // y retorne solo los elementos definidos
    // hint: use collect y pattern matching
    def filterOptions[T](l: List[Option[T]]): List[T] = {
      l.collect { case Some(algo) =>
        algo
      }
    }
    println(filterOptions(List(Some(1), None, Some(2))))
    // deberia devolver List(1,2)

    // Dada una lista de Any, retorne una lista de los elementos que son string
    def filterString(l: List[Any]): List[String] = {
      l.collect { case algo: String =>
        algo
      }
    }

    println(filterString(List(1, "hola", 2, "chao")))

  }
}
