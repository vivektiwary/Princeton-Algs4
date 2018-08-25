package org.sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestQuickSort {
  @Test
  public void testSort() {
    Comparable[] actual = {2, 5, 1, 3, 9, 7, 0};
    Comparable[] expected = {0, 1, 2, 3, 5, 7, 9};
    QuickSort.sort(actual, 0, actual.length - 1);
    assertArrayEquals(actual, expected);
  }

  @Test
  public void testSortWithSortedArray() {
    Comparable[] actual = {1, 2, 3, 4, 5};
    Comparable[] expected = {1, 2, 3, 4, 5};
    QuickSort.sort(actual, 0, actual.length - 1);
    assertArrayEquals(actual, expected);
  }

  @Test
  public void testSortWithReverseSortedArray() {
    Comparable[] actual = {5, 4, 3, 2, 1};
    Comparable[] expected = {1, 2, 3, 4, 5};
    QuickSort.sort(actual, 0, actual.length - 1);
    assertArrayEquals(actual, expected);
  }
}
