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
val iSort_Asc  = insertionSort[Int](menorQue)
val iSort_Desc = insertionSort[Int](mayorQue)

val qSort_Asc  = quickSort[Int](menorQue)
val qSort_Desc = quickSort[Int](mayorQue)

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
val sortAsc1 = iSort_Asc(List())

// Caso 2: un solo elemento
// Esperado: (List(42),0)
val sortAsc2 = iSort_Asc(List(42))

// Caso 3: ya ordenada
// Esperado: (List(1,2,3,4),3)
val sortAsc3 = iSort_Asc(List(1,2,3,4))

// Caso 4: orden inverso
// Esperado: (List(1,2,3,4),6)
val sortAsc4 = iSort_Asc(List(4,3,2,1))

// Caso 5: ejemplo del enunciado
// Esperado: (List(1,2,3,4,5,6),13)
val sortAsc5 = iSort_Asc(List(4,5,6,1,2,3))

// Caso 1: lista vacía
// Esperado: (List(),0)
val sortDesc1 = iSort_Asc(List())

// Caso 2: un solo elemento
// Esperado: (List(42),0)
val sortDesc2 = iSort_Asc(List(42))

// Caso 3: ya ordenada descendente
// Esperado: (List(9,7,5,3),6)
val sortDesc3 = iSort_Asc(List(9,7,5,3))

// Caso 4: lista inversa para '>'
// Esperado: (List(9,7,5,3),3)
val sortDesc4 = iSort_Asc(List(3,5,7,9))

// Caso 5: con duplicados
// Esperado: (List(5,5,3,2),3)
val sortDesc5 = iSort_Asc(List(2,3,5,5))

// ======================================================
// CASOS DE PRUEBA PARA menoresQue_noMenoresQue
// ======================================================

// Caso 1: lista vacía
// Esperado: (List(), List(), 0)
val part1 = menoresQue_noMenoresQue[Int](List(), 10, menorQue)

// Caso 2: un solo elemento igual al pivote -> va en noMenores, cuenta 2
// Esperado: (List(), List(1), 2)
val part2 = menoresQue_noMenoresQue[Int](List(1), 1, menorQue)

// Caso 3: ejemplo derivado del enunciado (tail respecto al pivote=4)
// Esperado: (List(1,2,3), List(5,6), 7)
val part3 = menoresQue_noMenoresQue[Int](List(5,6,1,2,3), 4, menorQue)

// Caso 4: mezcla con pivote intermedio
// Esperado: (List(1,2), List(3,4), 6)
val part4 = menoresQue_noMenoresQue[Int](List(1,2,3,4), 3, menorQue)

// Caso 5: todos iguales al pivote -> todos a noMenores, 2 por elemento
// Esperado: (List(), List(5,5,5), 6)
val part5 = menoresQue_noMenoresQue[Int](List(5,5,5), 5, menorQue)

// ======================================================
// CASOS DE PRUEBA PARA quickSort
// ======================================================

// Usamos qSort_Asc y qSort_Desc ya construidos antes.
// Esperados según la convención de la guía (+1 en raíz)

// Caso 1: lista vacía
// Esperado qSort_Asc: (List(), 0)
val qsortAsc1 = qSort_Asc(List())

// Caso 2: un solo elemento
// Esperado qSort_Asc: (List(42), 0)
val qsortAsc2 = qSort_Asc(List(42))

// Caso 3: ya ordenada ascendente
// Esperado qSort_Asc: (List(1,2,3,4), 13)
val qsortAsc3 = qSort_Asc(List(1,2,3,4))

// Caso 4: orden inverso
// Esperado qSort_Asc: (List(1,2,3,4), 7)
val qsortAsc4 = qSort_Asc(List(4,3,2,1))

// Caso 5: ejemplo del enunciado
// Esperado qSort_Asc: (List(1,2,3,4,5,6), 16)
val qsortAsc5 = qSort_Asc(List(4,5,6,1,2,3))

// Caso 1D: lista vacía
// Esperado qSort_Desc: (List(), 0)
val qsortDesc1 = qSort_Desc(List())

// Caso 2D: un solo elemento
// Esperado qSort_Desc: (List(42), 0)
val qsortDesc2 = qSort_Desc(List(42))

// Caso 3D: ya ordenada descendente
// Esperado qSort_Desc: (List(9,7,5,3), 13)
val qsortDesc3 = qSort_Desc(List(9,7,5,3))

// Caso 4D: orden inverso para '>'
// Esperado qSort_Desc: (List(9,7,5,3), 7)
val qsortDesc4 = qSort_Desc(List(3,5,7,9))

// Caso 5D: con duplicados
// Esperado qSort_Desc: (List(5,5,3,2), 8)
val qsortDesc5 = qSort_Desc(List(2,3,5,5))

// ======================================================
// CASOS DE PRUEBA PARA comparar
// ======================================================

// Caso 1: lista vacía -> ambos 0
// Esperado: (0, 0)
val comp1 = comparar[Int](iSort_Asc, qSort_Asc, List())

// Caso 2: un solo elemento -> ambos 0
// Esperado: (0, 0)
val comp2 = comparar[Int](iSort_Asc, qSort_Asc, List(42))

// Caso 3: ya ordenada ascendente
// Esperado: (3, 13)
val comp3 = comparar[Int](iSort_Asc, qSort_Asc, List(1,2,3,4))

// Caso 4: orden inverso
// Esperado: (6, 7)
val comp4 = comparar[Int](iSort_Asc, qSort_Asc, List(4,3,2,1))

// Caso 5: ejemplo del enunciado
// Esperado: (13, 16)
val comp5 = comparar[Int](iSort_Asc, qSort_Asc, List(4,5,6,1,2,3))

// Esperado: (-1, -1)
val comp6 = comparar[Int](iSort_Asc, qSort_Desc, List(4,5,6,1,2,3))

// ==============================
// Listas aleatorias (tamaños 5, 10, 20, 50)
// ==============================
val l5  = listaAlAzar(5)
val l10 = listaAlAzar(10)
val l20 = listaAlAzar(20)
val l50 = listaAlAzar(50)

// Ejecuta ambos algoritmos y compáralos
val q5    = qSort_Asc(l5)
val i5    = iSort_Asc(l5)
val comp5 = comparar[Int](iSort_Asc, qSort_Asc, l5)

val q10    = qSort_Asc(l10)
val i10    = iSort_Asc(l10)
val comp10 = comparar[Int](iSort_Asc, qSort_Asc, l10)

val q20    = qSort_Asc(l20)
val i20    = iSort_Asc(l20)
val comp20 = comparar[Int](iSort_Asc, qSort_Asc, l20)

val q50    = qSort_Asc(l50)
val i50    = iSort_Asc(l50)
val comp50 = comparar[Int](iSort_Asc, qSort_Asc, l50)