package org.sorting.PriorityQueues;

import org.helpers.Sorting;
/*
  This is a naive implementation using unsorted arrays
 */
public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> {
  private Key[] pq;
  private int size;

  public UnorderedMaxPriorityQueue(int capacity) {
    pq = (Key[]) new Comparable[capacity];
    size = 0;
  }

  public void insert(Key v) {
    if (size >= pq.length) { throw new RuntimeException("PQ is full"); }
    pq[size++] = v;
  }

  public Key delMax() {
    Key max = pq[0];
    int maxIndex = 0;
    for (int i = 1; i < size; i += 1) {
      if (pq[i].compareTo(max) > 0) {
        max = pq[i];
        maxIndex = i;
      }
    }
    Sorting.swap(pq, size - 1, maxIndex);
    size--;
    return max;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {
    UnorderedMaxPriorityQueue<Integer> umpq = new UnorderedMaxPriorityQueue<>(6);
    umpq.insert(10);
    umpq.insert(13);
    umpq.insert(3);
    umpq.insert(5);
    umpq.insert(9);
    umpq.insert(35);
    System.out.println(umpq.delMax());
  }
}
