package object Comparador {

  type AlgoritmoOrd[T] = List[T] => (List[T], Int)
  type Comparador[T] = (T, T) => Boolean

//  def insert[T](e: T, l: List[T], comp: Comparador[T]): (List[T], Int) = {
//    // Recibe un elemento de tipo T a insertar en una lista ordenada l de elementos de tipo T
//    // y devuelve, en una pareja, la lista ordenada incluyendo el elemento e
//    // y cuántas comparaciones se hicieron para lograrlo
//
//  }

//  def insertionSort[T](comp: Comparador[T]): AlgoritmoOrd[T] = {
//    // Recibe una lista de elementos de tipo T y un comparador de esos elementos
//    // y devuelve la lista ordenada y el número de comparaciones realizadas en una pareja
//    // usando el InsertionSort
//
//  }

  def menoresQue_noMenoresQue[T](l: List[T], v: T, comp: Comparador[T]): (List[T], List[T], Int) = {
    if (l.isEmpty) {
      (Nil, Nil, 0)
    } else {
      val (l1, l2, comps) = menoresQue_noMenoresQue(l.tail, v, comp)
      if (comp(l.head, v)) {
        (l.head :: l1, l2, comps + 1)
      } else {
        (l1, l.head :: l2, comps + 1)
      }
    }
  }





  def quickSort[T](comp: Comparador[T])(l: List[T]): (List[T], Int) = {
    if (l.isEmpty || l.tail.isEmpty) {
      (l, 0)
    } else {
      val pivote = l.head
      val (l1, l2, compsParticion) = menoresQue_noMenoresQue(l, pivote, comp)

      val (ordenL1, compsL1) = quickSort(comp)(l1)
      val (ordenL2, compsL2) = quickSort(comp)(l2)

      (ordenL1 ++ ordenL2, compsParticion + compsL1 + compsL2)
    }
  }




//  def comparar[T](a1: AlgoritmoOrd[T], a2: AlgoritmoOrd[T], l: List[T]): (Int, Int) = {
//    // Recibe dos algoritmos de ordenamiento y una lista para ordenar
//    // y devuelve una pareja con el número de comparaciones hechas por a1,
//    // y el número de comparaciones hechas por a2 para esa instancia de l en particular
//    // si los dos algoritmos dan el mismo resultado
//    // sino, devuelve (-1, -1)
//    val (l1, c1) = a1(l)
//    val (l2, c2) = a2(l)
//    if (l1 == l2) (c1, c2) else (-1, -1)
//  }

}
