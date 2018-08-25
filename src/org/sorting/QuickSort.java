package org.sorting;

import static org.helpers.Sorting.*;

public class QuickSort {
  private static int partition(Comparable[] arr, int low, int high) {
    // This partitioning method is a variation of Lomuto partition scheme
    Comparable pivot = arr[low]; // making low as pivot
    int j = high + 1;
    for (int i = high; i > low; i -= 1) {
      if (arr[i].compareTo(pivot) > 0) {
        j -= 1;
        swap(arr, j, i);
      }
    }
    swap(arr, j - 1, low);
    return (j - 1);
  }

  public static void sort(Comparable[] arr, int low, int high) {
    if (low >= high) { return; }
    int p = partition(arr, low, high);
    sort(arr, low, p - 1);
    sort(arr, p + 1, high);
  }

  public static void main(String[] args) {
    Comparable[] arr = {1, 5, 9, 2, 3, 11};
    sort(arr, 0, arr.length - 1);
    for (Comparable key : arr) {
      System.out.println(key);
    }
  }
}
