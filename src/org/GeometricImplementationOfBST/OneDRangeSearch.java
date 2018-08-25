package org.GeometricImplementationOfBST;

import org.Trees.BinarySearchTree;

public class OneDRangeSearch<Key extends Comparable<Key>, Value> {
  private BinarySearchTree<Key, Value> bst;

  public OneDRangeSearch() {
    bst = new BinarySearchTree<>();
  }

  public void put(Key key, Value val) {
    bst.put(key, val);
  }

  public int rangeCount(Key lo, Key hi) {
    if (bst.contains(hi)) return bst.rank(hi) - bst.rank(lo) + 1;
    else return  bst.rank(hi) - bst.rank(lo);
  }

  public void search(Key lo, Key hi) {
    bst.rangeSearch(lo, hi);
  }

  public static void main(String[] args) {
    OneDRangeSearch<Integer, Integer> rangeSearch = new OneDRangeSearch<>();
    rangeSearch.put(7, 28);
    rangeSearch.put(3, 12);
    rangeSearch.put(2, 8);
    rangeSearch.put(5, 20);
    rangeSearch.put(4, 16);
    rangeSearch.put(9, 36);
    System.out.println(rangeSearch.rangeCount(3, 5));
    System.out.println();
    rangeSearch.search(3, 5);
  }
}
