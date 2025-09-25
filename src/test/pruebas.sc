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

// ======================================================
// CASOS DE PRUEBA PARA menoresQue_noMenoresQue
// ======================================================

// Caso 1: lista vacía
// Esperado: (List(), List(), 0)
val partAsc1 = menoresQue_noMenoresQue(List(), 5, menorQue)

// Caso 2: todos menores que pivote
// Esperado: (List(1,2,3), List(), 3)
val partAsc2 = menoresQue_noMenoresQue(List(1,2,3), 5, menorQue)

// Caso 3: todos mayores o iguales al pivote
// Esperado: (List(), List(6,7,8), 3)
val partAsc3 = menoresQue_noMenoresQue(List(6,7,8), 5, menorQue)

// Caso 4: mezcla de menores y mayores
// Esperado: (List(1,4), List(6,9), 4)
val partAsc4 = menoresQue_noMenoresQue(List(1,4,6,9), 5, menorQue)

// Caso 5: con duplicados iguales al pivote
// Esperado: (List(1,2), List(5,5,6), 5)
val partAsc5 = menoresQue_noMenoresQue(List(1,2,5,5,6), 5, menorQue)

// Caso 1: lista vacía
// Esperado: (List(), List(), 0)
val partDesc1 = menoresQue_noMenoresQue(List(), 5, mayorQue)

// Caso 2: todos “menores” según '>'
// Aquí “menores” significa que a > pivote
// Lista = [9,8,7], pivote=5 → todo en primera lista
// Esperado: (List(9,8,7), List(), 3)
val partDesc2 = menoresQue_noMenoresQue(List(9,8,7), 5, mayorQue)

// Caso 3: todos “no menores”
// Lista = [1,2,3], pivote=5 → ninguno > 5
// Esperado: (List(), List(1,2,3), 3)
val partDesc3 = menoresQue_noMenoresQue(List(1,2,3), 5, mayorQue)

// Caso 4: mezcla
// Lista = [9,4,6,2], pivote=5 → mayores [9,6], no mayores [4,2]
// Esperado: (List(9,6), List(4,2), 4)
val partDesc4 = menoresQue_noMenoresQue(List(9,4,6,2), 5, mayorQue)

// Caso 5: duplicados iguales al pivote
// Lista = [7,5,5,3], pivote=5 → “menores” [7], “no menores” [5,5,3]
// Esperado: (List(7), List(5,5,3), 4)
val partDesc5 = menoresQue_noMenoresQue(List(7,5,5,3), 5, mayorQue)

// ======================================================
// CASOS DE PRUEBA PARA quickSort
// ======================================================

val qSortAsc  = quickSort[Int](menorQue)
val qSortDesc = quickSort[Int](mayorQue)

// Caso 1: lista vacía
// Esperado: (List(),0)
val qAsc1 = qSortAsc(List())

// Caso 2: un solo elemento
// Esperado: (List(42),0)
val qAsc2 = qSortAsc(List(42))

// Caso 3: ya ordenada ascendente
// Ejemplo: List(1,2,3)
// Resultado esperado: (List(1,2,3), 2)
val qAsc3 = qSortAsc(List(1,2,3))

// Caso 4: lista inversa
// Ejemplo: List(3,2,1)
// Resultado esperado: (List(1,2,3), 3)
val qAsc4 = qSortAsc(List(3,2,1))

// Caso 5: ejemplo del enunciado
// Entrada: List(4,5,6,1,2,3)
// Esperado: (List(1,2,3,4,5,6),16)
val qAsc5 = qSortAsc(List(4, 5, 6, 1, 2, 3))

// Caso 1: lista vacía
// Esperado: (List(),0)
val qDesc1 = qSortDesc(List())

// Caso 2: un solo elemento
// Esperado: (List(42),0)
val qDesc2 = qSortDesc(List(42))

// Caso 3: ya ordenada descendente
// Ejemplo: List(9,7,5)
// Esperado: (List(9,7,5),2)
val qDesc3 = qSortDesc(List(9,7,5))

// Caso 4: lista inversa para '>'
// Ejemplo: List(5,7,9)
// Esperado: (List(9,7,5),3)
val qDesc4 = qSortDesc(List(5,7,9))

// Caso 5: con duplicados
// Ejemplo: List(5,5,3,3,7)
// Esperado: (List(7,5,5,3,3), 7)
val qDesc5 = qSortDesc(List(5,5,3,3,7))

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