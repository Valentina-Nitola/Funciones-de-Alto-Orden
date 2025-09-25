import Comparador._
import scala.util.Random

val random = new Random()

def listaAlAzar(long: Int): List[Int] = {
  // Crea una lista de 'long' enteros con valores aleatorios entre 1 y long*2
  val v = Vector.fill(long) {
    random.nextInt(long * 2) + 1
    }
  v.toList
}

def menorQue(a: Int, b: Int): Boolean = a < b
def mayorQue(a: Int, b: Int): Boolean = a > b

// Algoritmos generados con los comparadores
val iSortAsc  = insertionSort[Int](menorQue)
val iSortDesc = insertionSort[Int](mayorQue)

// ======================================================
// CASOS DE PRUEBA PARA insert
// ======================================================

// Caso 1: lista vacía
// Esperado: (List(5),0)
val insAsc1 = insert(5, List(), menorQue)

// Caso 2: insertar al inicio
// Esperado: (List(1,2,3),1)
val insAsc2 = insert(1, List(2,3), menorQue)

// Caso 3: insertar en el medio
// Esperado: (List(2,4,5,6),3)
val insAsc3 = insert(5, List(2,4,6), menorQue)

// Caso 4: insertar al final
// Esperado: (List(2,4,6,8),3)
val insAsc4 = insert(8, List(2,4,6), menorQue)

// Caso 5: insertar duplicado
// Esperado: (List(3,3,3,5),3)
val insAsc5 = insert(3, List(3,3,5), menorQue)

// Caso 1: lista vacía
// Esperado: (List(5),0)
val insDesc1 = insert(5, List(), mayorQue)

// Caso 2: insertar al inicio (más grande primero)
// Esperado: (List(9,7,6),1)
val insDesc2 = insert(9, List(7,6), mayorQue)

// Caso 3: insertar en el medio
// Esperado: (List(9,7,6),2)
val insDesc3 = insert(7, List(9,6), mayorQue)

// Caso 4: insertar al final
// Esperado: (List(9,7,6,4),3)
val insDesc4 = insert(4, List(9,7,6), mayorQue)

// Caso 5: insertar duplicado
// Esperado: (List(7,7,6,5),2)
val insDesc5 = insert(7, List(7,6,5), mayorQue)

// ======================================================
// CASOS DE PRUEBA PARA insertionSort
// ======================================================

// Caso 1: lista vacía
// Esperado: (List(),0)
val sortAsc1 = iSortAsc(List())

// Caso 2: un solo elemento
// Esperado: (List(42),0)
val sortAsc2 = iSortAsc(List(42))

// Caso 3: ya ordenada
// Esperado: (List(1,2,3,4),3)
val sortAsc3 = iSortAsc(List(1,2,3,4))

// Caso 4: orden inverso
// Esperado: (List(1,2,3,4),6)
val sortAsc4 = iSortAsc(List(4,3,2,1))

// Caso 5: ejemplo del enunciado
// Esperado: (List(1,2,3,4,5,6),13)
val sortAsc5 = iSortAsc(List(4,5,6,1,2,3))

// Caso 1: lista vacía
// Esperado: (List(),0)
val sortDesc1 = iSortDesc(List())

// Caso 2: un solo elemento
// Esperado: (List(42),0)
val sortDesc2 = iSortDesc(List(42))

// Caso 3: ya ordenada descendente
// Esperado: (List(9,7,5,3),3)
val sortDesc3 = iSortDesc(List(9,7,5,3))

// Caso 4: lista inversa para '>'
// Esperado: (List(9,7,5,3),6)
val sortDesc4 = iSortDesc(List(3,5,7,9))

// Caso 5: con duplicados
// Esperado: (List(5,5,3,2),6)
val sortDesc5 = iSortDesc(List(2,3,5,5))