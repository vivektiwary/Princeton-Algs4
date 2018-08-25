package org.Trees;

import javax.sound.midi.Soundbank;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
  private class Node {
    Key key;
    Value val;
    Node left;
    Node right;
    int count;

    Node(Key k, Value v) {
      key = k;
      val = v;
      left = null;
      right = null;
      count = 1;
    }
  }

  private Node root;
  private int size;

  public BinarySearchTree() {
    root = null;
    size = 0;
  }

  private Node put(Node node, Key k, Value v) {
    if (node == null) {
      return new Node(k, v);
    }

    int cmp = k.compareTo(node.key);
    if (cmp < 0) {
      node.left = put(node.left, k, v);
    } else if (cmp > 0) {
      node.right = put(node.right, k, v);
    } else {
      node.val = v;
    }
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  public void put(Key k, Value v) {
    root = put(root, k, v);
    size += 1;
  }

  private int rank(Node node, Key k) {
    if (node == null) return 0;
    int cmp = k.compareTo(node.key);
    if (cmp < 0)      return rank(node.left, k);
    else if (cmp > 0) return 1 + size(node.left) + rank(node.right, k);
    else              return size(node.left);
  }

  public int rank(Key k) {
    return rank(root, k);
  }

  private int size(Node node) {
    if (node == null) return 0;
    return node.count;
  }

  public int size() {
    return size(root);
  }

  private Value get(Node node, Key k) {
    if (node == null)  return null;

    int cmp = k.compareTo(node.key);
    if (cmp < 0)      return get(node.left, k);
    else if (cmp > 0) return get(node.right, k);
    else              return node.val;
  }

  public Value get(Key k) {
    return get(root, k);
  }

  private void rangeSearch(Node node, Key lo, Key hi) {
    if (node == null) return;

    Key key = node.key;
    if (lo.compareTo(key) < 0) {
      rangeSearch(node.left, lo, hi);
    }
    if (key.compareTo(lo) >= 0 && key.compareTo(hi) <= 0) {
      System.out.print(key + " ");
    }
    if (hi.compareTo(key) > 0) {
      rangeSearch(node.right, lo, hi);
    }
  }

  public void rangeSearch(Key lo, Key hi) {
    rangeSearch(root, lo, hi);
  }

  public boolean contains(Key k) {
    return get(k) != null;
  }

  public Value getIterative(Key k) {
    Node node = root;
    while (node != null) {
      int cmp = k.compareTo(node.key);
      if (cmp < 0)      node = node.left;
      else if (cmp > 0) node = node.right;
      else              return node.val;
    }
    return null;
  }

  private Node deleteMin(Node node) {
    if (node.left == null)  return node.right;
    node.left = deleteMin(node.left);
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  public Node min(Node p) {
    if (p == null) return p;
    while (p.left != null) p = p.left;
    return p;
  }

  private Node delete(Node node, Key k) {
    if (node == null) return null;

    int cmp = k.compareTo(node.key);
    if (cmp < 0) {
      node.left = delete(node.left, k);
    } else if (cmp > 0) {
      node.right = delete(node.right, k);
    } else {
      if (node.left == null) return node.right;
      if (node.right == null) return node.left;

      Node t = node;
      node = min(node.right);
      node.right = deleteMin(t.right);
      node.left = t.left;
    }
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  public void delete(Key k) {
    root = delete(root, k);
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
    bst.put(5, 20);
    bst.put(2, 8);
    bst.put(1, 4);
    bst.put(9, 36);
    bst.put(7, 28);
    bst.put(13, 52);
    bst.put(12, 48);
    System.out.println(bst.rank(14));
    System.out.println("hello");
  }
}
