package org.sorting.PriorityQueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnorderedMaxPriorityQueue {
  @Test
  public void testMaxPriorityQueue() {
    int [] arr = {3, 1, 4, 5, 9, 13};
    UnorderedMaxPriorityQueue<Integer> mpq = new UnorderedMaxPriorityQueue<>(6);
    for (int elem : arr) {
      mpq.insert(elem);
    }
    assertEquals(mpq.delMax(), (Integer) 13);
  }
}
