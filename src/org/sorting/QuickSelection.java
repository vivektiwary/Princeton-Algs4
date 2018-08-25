package org.sorting;

import org.helpers.Sorting;

/*
  Selecting the Kth largest element in an array
 */
public class QuickSelection {
  private static int partition(Comparable[] arr, int lo, int hi)  {
    int i = lo;
    int j = hi + 1;
    while (true) {
      while (arr[++i].compareTo(arr[lo]) < 0) { if (i == hi) break; }
      while (arr[--j].compareTo(arr[lo]) > 0) { if (j == lo) break; }

      if (i >= j) { break; }

      Sorting.swap(arr, j, i);
    }
    Sorting.swap(arr, j, lo);
    return j;
  }

  public static Comparable selectKth(Comparable[] arr, int k) {
    int lo = 0, hi = arr.length - 1;
    int pivot;
    while (lo < hi) {
      pivot = partition(arr, lo, hi);
      if (pivot > k)        hi = pivot - 1;
      else if (pivot < k)   lo = pivot + 1;
      else                  return arr[k];
    }
    return arr[k];
  }

  public static void main(String[] args) {
    Comparable[] arr = {2, 4, 1, 7, 9, 12, 5};
    System.out.println(QuickSelection.selectKth(arr, 2));
  }
}
