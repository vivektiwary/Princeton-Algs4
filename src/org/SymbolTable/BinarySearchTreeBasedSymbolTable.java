package org.SymbolTable;
import org.Trees.BinarySearchTree;

public class BinarySearchTreeBasedSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
  private BinarySearchTree<Key, Value> bst;

  public BinarySearchTreeBasedSymbolTable() {
    bst = new BinarySearchTree<>();
  }

  public void put(Key key, Value val) {
    bst.put(key, val);
  }

  public Value get(Key key) {
    return bst.getIterative(key);
  }

  public void delete(Key key) {
    bst.delete(key);
  }

  public boolean contains(Key key) {
    return bst.getIterative(key) != null;
  }

  public boolean isEmpty() {
    return bst.size() == 0;
  }

  public int size() {
    return bst.size();
  }
}
