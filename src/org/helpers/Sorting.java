package org.helpers;

import java.util.Random;

public class Sorting {
  public static void randomShuffle(Comparable[] arr) {
    // Fisher–Yates shuffle or Knuth shuffle
    Random rnd = new Random();
    for (int i = 0; i < arr.length; i += 1) {
      // generate a uniform random number between 0 and i
      int randomIndex = rnd.nextInt(i + 1);
      // swap it with ith position element
      swap(arr, i, randomIndex);
    }
  }

  public static void swap(Comparable[] arr, int index1, int index2) {
    Comparable temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
}
