package org.LinkedList;

public class ListWithKeyAndValue<Key, Value> {
  private class Node {
    Key key;
    Value val;
    Node next;

    Node(Key k, Value v, Node n) {
      key = k;
      val = v;
      next = n;
    }
  }

  private Node sentinel;
  private int size;

  public ListWithKeyAndValue() {
    sentinel = new Node(null , null, null);
    size = 0;
  }

  public void put(Key k, Value v) {
    Node newNode = new Node(k, v, null);

    Node temp = sentinel;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    size += 1;
  }

  public Value get(Key k) {
    Node temp = sentinel;
    while (temp != null) {
      if (temp.key == k) {
        return temp.val;
      }
      temp = temp.next;
    }
    return null;
  }

  public void delete(Key k) {
    Node prev = sentinel;
    Node p = sentinel.next;
    while (p != null) {
      if (p.key.equals(k)) {
        prev.next = p.next;
        p.next = null;
        return;
      }
      prev = p;
      p = p.next;
    }
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    ListWithKeyAndValue<String, Integer> list = new ListWithKeyAndValue<>();
    list.put("hi", 5);
    list.put("how", 7);
    list.put("when", 9);
    list.put("where", 11);
    list.delete("how");
    System.out.println(list.get("how"));
  }
}
