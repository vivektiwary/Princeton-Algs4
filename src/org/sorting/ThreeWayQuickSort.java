package org.sorting;

import org.helpers.Sorting;

public class ThreeWayQuickSort {
  private static void sort(Comparable[] arr, int lo, int hi) {
    if (lo >= hi) { return; }
    int lt = lo, gt = hi;
    Comparable item = arr[lo];
    int i = lo;
    while (i <= gt) {
      int cmp = arr[i].compareTo(item);
      if      (cmp < 0) Sorting.swap(arr, lt++, i++);
      else if (cmp > 0) Sorting.swap(arr, gt--, i);
      else              i++;
    }

    sort(arr, lo, lt - 1);
    sort(arr, gt + 1, hi);
  }

  public static void sort(Comparable[] arr) {
    Sorting.randomShuffle(arr);
    sort(arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    Comparable[] arr = {9, 1, 2, 5, 18, 13, 3, 4, 17};
    ThreeWayQuickSort.sort(arr);
    for (Comparable item : arr) {
      System.out.println(item);
    }
  }
}
