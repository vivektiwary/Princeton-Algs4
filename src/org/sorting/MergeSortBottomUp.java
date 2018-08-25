package org.sorting;

public class MergeSortBottomUp {
  private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
    System.arraycopy(arr, low, aux, low, (high - low + 1));

    int i = low, j = mid + 1;
    for (int k = low; k <= high; k += 1) {
      if (i > mid) { arr[k] = aux[j++]; }
      else if (j > high) { arr[k] = aux[i++]; }
      else if (aux[j].compareTo(aux[i]) >= 0) { arr[k] = aux[i++]; }
      else { arr[k] = aux[j++]; }
    }
  }

  private static void sort(Comparable[] arr, Comparable[] aux, int low, int high) {
//    if (low >= high) return;
//    int mid = low + (high - low) / 2;
//    sort(arr, aux, low, mid);
//    sort(arr, aux, mid + 1, high);
//    merge(arr, aux, low, mid, high);
  }

  public static void sort(Comparable[] arr) {
    Comparable[] aux = new Comparable[arr.length];
//    sort(arr, aux, 0, arr.length - 1);
    for (int sz = 1; sz < arr.length; sz = sz + sz) {
      for (int lo = 0; lo < arr.length - sz; lo += sz + sz) {
        merge(arr, aux, lo, (lo + sz - 1), Math.min(lo + (sz + sz - 1), arr.length - 1));
      }
    }
    // using size + size here because addition is more faster than multiplication
//    for (int size = 2; size <= arr.length; size = size + size) {
//      for (int lo = 0; lo <= arr.length - size; lo += (size)) {
//        merge(arr, aux, lo, (lo + size/ 2 - 1), Math.min(lo + (size - 1), arr.length - 1));
//      }
//    }
  }
  public static void main(String[] args) {
//    Comparable[] a = {12, 14, 2};
    Comparable[] a = { 1, 9, 4, 3, 2, 1, 5};
    MergeSortBottomUp.sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }
}
