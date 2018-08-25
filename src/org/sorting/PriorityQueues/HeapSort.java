package org.sorting.PriorityQueues;

import org.helpers.Sorting;

public class HeapSort<Key extends Comparable<Key>> {
  private Key[] arr;
  private int size;

  public HeapSort(Key[] inputArray) {
    arr = inputArray;
    size = arr.length - 1;
  }

  public void sort() {
    heapify();
    while (size > 0) {
      delMax();
    }
  }

  private void heapify() {
    for (int k = size / 2; k >= 0; k -= 1) {
      sink(k, size);
    }
  }

  private void delMax() {
    Sorting.swap(arr, 0, size--);
    sink(0, size);
  }

  private void sink(int index, int size) {
    while (2 * index <= size) {
      int childIndex = 2 * index;
      if (childIndex < size && less(childIndex, childIndex + 1))  childIndex += 1;
      if (!less(index, childIndex)) break;
      Sorting.swap(arr, index, childIndex);
      index = childIndex;
    }
  }

  private boolean less(int i, int j) {
    return arr[i].compareTo(arr[j]) < 0;
  }

  public static void main(String[] args) {
    Integer [] arr = {9, 2, 7, 1, 5, 15};
    HeapSort<Integer> hs = new HeapSort<>(arr);
    hs.sort();
    for (int a : arr) {
      System.out.println(a);
    }
  }
}
