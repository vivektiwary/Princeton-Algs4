package org.Trees;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBinarySearchTree {
  @Test
  public void testDeleteMin() {
    BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
    bst.put(5, 20);
    bst.put(2, 8);
    bst.put(1, 4);
    bst.put(9, 36);
    bst.put(7, 28);
    bst.put(13, 52);
    bst.put(12, 48);
    bst.deleteMin();
    assertEquals(bst.get(1), null);
  }

  @Test
  public void testDelete() {
    BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
    bst.put(5, 20);
    bst.put(2, 8);
    bst.put(1, 4);
    bst.put(9, 36);
    bst.put(7, 28);
    bst.put(13, 52);
    bst.put(12, 48);
    bst.delete(9);
    assertEquals(bst.get(9), null);
  }
}
