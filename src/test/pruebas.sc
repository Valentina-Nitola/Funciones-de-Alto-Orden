import Comparador._
import scala.util.Random

val random = new Random()

def listaAlAzar(long: Int): List[Int] = {
  // Crea una lista de 'long' enteros con valores aleatorios entre 1 y long*2
  val v = Vector.fill(long) { random.nextInt(long * 2) + 1 }
  v.toList
}

def menorQue(a: Int, b: Int): Boolean = a < b
def mayorQue(a: Int, b: Int): Boolean = a > b

// Algoritmos generados con los comparadores
val iSortAsc  = insertionSort[Int](menorQue)
val iSortDesc = insertionSort[Int](mayorQue)
iSortAsc(List(4, 5, 6, 1, 2, 3))

val qSortAsc  = quickSort[Int](menorQue)
val qSortDesc = quickSort[Int](mayorQue)
qSortAsc(List(4, 5, 6, 1, 2, 3))

// Comparaciones sobre una lista fija
comparar(iSortAsc, qSortAsc,  List(4, 5, 6, 1, 2, 3))
comparar(iSortAsc, qSortDesc, List(4, 5, 6, 1, 2, 3))

// Listas grandes (ascendente y descendente)
val lAsc100   = (1 to 100).toList
val lAsc1000  = (1 to 1000).toList
val lDsc100   = (1 to 100).toList.reverse
val lDsc1000  = (1 to 1000).toList.reverse

comparar(iSortAsc, qSortAsc, lAsc100)
comparar(iSortAsc, qSortAsc, lAsc1000)
comparar(iSortAsc, qSortAsc, lDsc100)
comparar(iSortAsc, qSortAsc, lDsc1000)

// Listas aleatorias de distintos tamaños
val l5  = listaAlAzar(5)
val l10 = listaAlAzar(10)
val l20 = listaAlAzar(20)
val l50 = listaAlAzar(50)

// Ejecutar ambos algoritmos en listas aleatori
