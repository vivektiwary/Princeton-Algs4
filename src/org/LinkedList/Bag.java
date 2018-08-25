package org.LinkedList;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
  private SList<Item> sl;

  public Bag() {
    sl = new SList<>();
  }

  public void add(Item i) {
    sl.add(i);
  }

  public int size() {
    return sl.size();
  }

  @Override
  public Iterator<Item> iterator() {
    return sl.iterator();
  }
}
