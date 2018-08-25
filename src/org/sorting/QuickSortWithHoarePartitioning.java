package org.sorting;

import org.helpers.Sorting;

public class QuickSortWithHoarePartitioning {
  private static int partition(Comparable[] arr, int lo, int hi) {
    int i = lo;
    int j = hi + 1;

    while (true) {
      while (arr[++i].compareTo(arr[lo]) < 0) { if (i == hi) break; }
      while (arr[--j].compareTo(arr[lo]) > 0) { if (j == lo) break; }

      if (i >= j) break;
      Sorting.swap(arr, i, j);
    }
    Sorting.swap(arr, lo, j);
    return j;
  }

  private static void sort(Comparable[] arr, int lo, int hi) {
    if (lo >= hi) { return; }
    int pivot = partition(arr, lo, hi);
    sort(arr, lo, pivot - 1);
    sort(arr, pivot + 1, hi);
  }

  public static void sort(Comparable[] arr) {
    Sorting.randomShuffle(arr);
    sort(arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    Comparable[] arr = {9, 1, 3, 7, 2, 19, 13, 5};
    QuickSortWithHoarePartitioning.sort(arr);
    for (Comparable item : arr) {
      System.out.println(item);
    }
  }
}
