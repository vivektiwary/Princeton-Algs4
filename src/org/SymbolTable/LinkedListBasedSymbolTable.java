package org.SymbolTable;

import org.LinkedList.ListWithKeyAndValue;

public class LinkedListBasedSymbolTable<Key, Value> implements SymbolTable<Key, Value> {
  private ListWithKeyAndValue<Key, Value> slist;

  public LinkedListBasedSymbolTable() {
    slist = new ListWithKeyAndValue<>();
  }

  public void put(Key key, Value val) {
    slist.put(key, val);
  }

  public Value get(Key key) {
    return slist.get(key);
  }

  public void delete(Key key) {
    slist.delete(key);
  }

  public boolean contains(Key key) {
    return slist.get(key) != null;
  }

  public boolean isEmpty() {
    return slist.size() == 0;
  }

  public int size() {
    return slist.size();
  }
}
