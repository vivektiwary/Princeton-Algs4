package org.sorting;

public class InsertionSort {
  public static void sort(Comparable[] arr) {
    for (int i = 1; i < arr.length; i += 1) {
      Comparable key = arr[i];
      int j = i - 1;
      while ( j >= 0 && (arr[j].compareTo(key) > 0)) {
        arr[j + 1] = arr[j];
        j -= 1;
      }

      arr[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    Comparable[] arr = { 9, 1, 5, 3, 7, 6};
    InsertionSort.sort(arr);
    for (Comparable item : arr) {
      System.out.println(item);
    }
  }
}
