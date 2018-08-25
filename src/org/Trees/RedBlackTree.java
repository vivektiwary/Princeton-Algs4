package org.Trees;

import javax.swing.undo.CannotUndoException;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private class Node {
    Key key;
    Value val;
    Node left;
    Node right;
    int count;
    boolean color;
    Node(Key k, Value v, boolean color) {
      key = k;
      val = v;
      this.color = color;
      count = 1;
    }
  }

  private Node root;

  public RedBlackTree() {
    root = null;
  }

  public boolean isRed(Node node) {
    if (node == null) return false;
    return node.color == RED;
  }

  private Node put(Node p, Key key, Value val) {
    if (p == null) return new Node(key, val, RED);
    int cmp = key.compareTo(p.key);
    if (cmp < 0)       p.left = put(p.left, key, val);
    else if (cmp > 0)  p.right = put(p.right, key, val);
    else               p.val = val;

    return balance(p);
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
  }

  public boolean isEmpty() {
    return root == null;
  }

  private Node deleteMin(Node p) {
    if (p.left == null) return null;

    if (!isRed(p.left) && !isRed(p.left.left))
      p = moveRedLeft(p);

    p.left = deleteMin(p.left);
    return balance(p);
  }

  public void deleteMin() {
    // If both children are black make root as red:  Not sure why we are doing this
    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;

    root = deleteMin(root);
    if (!isEmpty())
      root.color = BLACK;
  }

  private Node deleteMax(Node node) {
    if (isRed(node.left))
      node = rotateRight(node);

    if (node.right == null) return null;

    if (!isRed(node.right) && !isRed(node.right.left))
      node = moveRedRight(node);

    node.right = deleteMax(node.right);
    return balance(node);
  }

  public void deleteMax() {
    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;

    root = deleteMax(root);

    if (!isEmpty())
      root.color = BLACK;
  }

  public Node min(Node node) {
    Node temp = node;
    if (temp == null) return null;
    while (temp.left != null) temp = temp.left;
    return temp;
  }

  private Node delete(Node node, Key key) {
    if (key.compareTo(node.key) < 0) {
      if (!isRed(node.left) && !isRed(node.left.left))
        node = moveRedLeft(node);

      node.left = delete(node.left, key);
    } else {
      if (isRed(node.left))
        node = rotateRight(node);
      if (key.compareTo(node.key) == 0 && node.right == null)
        return null;
      if (!isRed(node.right) && !isRed(node.right.left))
        node = moveRedRight(node);
      if (key.compareTo(node.key) == 0) {
        Node min = min(node.right);
        node.key = min.key;
        node.val = min.val;

        node.right = deleteMin(node.right);
      } else {
        node.right = delete(node.right, key);
      }
    }
    return balance(node);
  }

  public void delete(Key key) {
    if (!isRed(root.left) && !isRed(root.right))
      root.color = RED;

    root = delete(root, key);

    if (!isEmpty())
      root.color = BLACK;
  }

  /*
    Helper methods
   */

  private Node balance(Node p) {
    if (isRed(p.right) && !isRed(p.left))       p = rotateLeft(p);
    if (isRed(p.left) && isRed(p.left.left))    p = rotateRight(p);
    if (isRed(p.left) && isRed(p.right))        flipColors(p);

    return p;
  }

  private Node moveRedLeft(Node node) {
    flipColors(node);
    if (isRed(node.right.left)) {
      node.right = rotateRight(node.right);
      node = rotateLeft(node);
      flipColors(node);
    }
    return node;
  }

  private Node moveRedRight(Node node) {
    flipColors(node);
    if (isRed(node.left.left)) {
      node = rotateRight(node);
      flipColors(node);
    }
    return node;
  }

  private Node rotateLeft(Node node) {
    Node h = node.right;
    node.right = h.left;
    h.left = node;
    h.color = node.color;
    node.color = RED;
    return h;
  }

  private Node rotateRight(Node node) {
    Node h = node.left;
    node.left = h.right;
    h.right = node;
    h.color = node.color;
    node.color = RED;
    return h;
  }

  private void flipColors(Node node) {
    node.color = !node.color;
    node.left.color = !node.left.color;
    node.right.color = !node.right.color;
  }

  public static void main(String[] args) {
    RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
    rbt.put(2, 8);
    rbt.put(3, 12);
    rbt.put(5, 20);
    rbt.put(7, 28);
    rbt.put(9, 36);
    rbt.put(4, 16);
    System.out.println("hello");
    rbt.delete(3);
    System.out.println("hello");
  }
}
