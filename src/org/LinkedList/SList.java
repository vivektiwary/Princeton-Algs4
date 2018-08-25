package org.LinkedList;

import java.util.Iterator;

public class SList<Item> implements Iterable<Item> {
  private Node sentinel;
  private int size;

  @Override
  public Iterator<Item> iterator() {
    return new SListIterator();
  }

  private class SListIterator implements Iterator<Item> {
    private Node current = sentinel.next;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      Item i = current.item;
      current = current.next;
      return i;
    }
  }

  private class Node {
    Item item;
    Node next;

    Node(Item i, Node p) {
      item = i;
      next = p;
    }
  }

  public SList() {
    sentinel = new Node(null, null);
    size = 0;
  }

  public void add(Item i) {
    sentinel.next = new Node(i, sentinel.next);
  }

  public int size() {
    return size;
  }

  public Boolean isEmpty() {
    return size() == 0;
  }

  public static void main(String[] args) {
    SList<Integer> sl = new SList<>();
    sl.add(2);
    sl.add(5);
    sl.add(8);
    sl.add(1);
    sl.add(9);
  }
}
