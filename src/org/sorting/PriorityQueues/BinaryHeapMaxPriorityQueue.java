package org.sorting.PriorityQueues;

import org.helpers.Sorting;

public class BinaryHeapMaxPriorityQueue<Key extends Comparable<Key>> {
  private Key[] pq;
  private int size;

  public BinaryHeapMaxPriorityQueue(int capacity) {
    pq = (Key[]) new Comparable[capacity + 1];
    size = 0;
  }

  private void swim(int j) {
    while (j > 1 && less(j / 2, j)) {
      Sorting.swap(pq, j, j/2);
      j /= 2;
    }
  }

  private void sink(int dissentIndex) {
    while (2 * dissentIndex <= size)  {
      int childIndex = 2 * dissentIndex;

      if (childIndex < size && less(childIndex, childIndex + 1)) {
        childIndex += 1;
      }
      if (!less(dissentIndex, childIndex)) break;
      Sorting.swap(pq, dissentIndex, childIndex);
      dissentIndex = childIndex;
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(Key v) {
    pq[++size] = v;
    swim(size);
  }

  public Key delMax() {
    Key max = pq[1];
    Sorting.swap(pq, 1, size);
    pq[size--] = null;
    sink(1);
    return max;
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  public static void main(String[] args) {
    BinaryHeapMaxPriorityQueue<Integer> bhmp = new BinaryHeapMaxPriorityQueue<>(6);
    bhmp.insert(12);
    bhmp.insert(4);
    bhmp.insert(9);
    bhmp.insert(15);
    bhmp.insert(2);
    bhmp.insert(19);
    for (int i = 0; i < 6; i += 1) {
      System.out.println(bhmp.delMax());
    }
  }
}
