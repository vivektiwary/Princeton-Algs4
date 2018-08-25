package org.sorting;

public class MergeSort {
  public static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
    System.arraycopy(arr, low, aux, low, (high - low + 1));

    int i = low, j = mid + 1;
    for (int k = low; k <= high; k += 1) {
      if (i > mid) { arr[k] = aux[j++]; }
      else if (j > high) { arr[k] = aux[i++]; }
//      else if (aux[i] <= aux[j]) { arr[k] = aux[i++]; }
      else if (aux[i].compareTo(aux[j]) <= 0) { arr[k] = aux[i++]; }
      else { arr[k] = aux[j++]; }
    }
  }

  private static void sort(Comparable[] arr, Comparable[] aux, int low, int high) {
    if (low >= high)  return;

    /*
      This is a bad idea, as it might cause overflows because
      sometimes the number (low + high) would be bigger than the memory allocated to either of low or high.
    */
    // int mid = Math.round((low + high) / 2);

    int mid = low + (high - low) / 2;
    sort(arr, aux, low, mid);
    sort(arr, aux, mid + 1, high);
    merge(arr, aux, low, mid, high);
  }

  public static void sort(Comparable[] arr) {
    Comparable[] aux = new Comparable[arr.length];
    sort(arr, aux, 0, arr.length - 1);
  }

  public static void main(String[] args) {
//    Comparable[] a = {12, 14, 2};
    Comparable[] a = {"a", "abc", "kdef"};
    MergeSort.sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }
}
