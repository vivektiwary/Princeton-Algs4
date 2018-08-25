package org.sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMergeSortBottomUp {
  @Test
  public void testMergeSort() {
    Comparable[] actual = { 2, 1, 4, 3 };
    Comparable[] expected = { 1, 2, 3, 4};
    MergeSortBottomUp.sort(actual);
    assertArrayEquals(expected, actual);
  }
}
