package org.sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMergeSort {
  @Test
  public void testMergeSort() {
    Comparable[] actual = { 2, 1, 4, 3 };
    Comparable[] expected = { 1, 2, 3, 4};
    MergeSort.sort(actual);
    assertArrayEquals(actual, expected);
  }
}
