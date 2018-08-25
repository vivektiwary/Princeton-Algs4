package org.SymbolTable;

public class BinarySearchBasedSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
  private Key[] keys;
  private Value[] values;
  private int size;

  public BinarySearchBasedSymbolTable(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    values = (Value[]) new Object[capacity];
    size = 0;
  }

  private void shiftKeyBy1(int index) {
    System.arraycopy(keys, index, keys, index + 1, size - index);
  }

  private void shiftValueBy1(int index) {
    System.arraycopy(values, index, values, index + 1, size - index);
  }

  public void put(Key key, Value val) {
    int i;
    for (i = 0; i < size; i += 1) {
      if (keys[i].compareTo(key) > 0) {
        shiftKeyBy1(i);
        keys[i] = key;
        shiftValueBy1(i);
        values[i] = val;
        size += 1;

        return;
      }
    }
    keys[i] = key;
    values[i] = val;
    size += 1;
  }

  private int rank(Key key) {
    int lo = 0;
    int hi = size - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int cmp = keys[mid].compareTo(key);

      if      (cmp > 0)  hi = mid - 1;
      else if (cmp < 0)  lo = mid + 1;
      else               return mid;
    }
    return lo;
  }

  public Value get(Key key) {
    if (isEmpty()) return null;
    int i = rank(key);
    if (keys[i].compareTo(key) == 0) return values[i];
    return null;
  }

  private void exchange(Key[] keys, int i, int j) {
    Key temp = keys[i];
    keys[i] = keys[j];
    keys[j] = temp;
  }

  private void exchange(Value[] values, int i, int j) {
    Value temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }

  public void delete(Key key) {
    if (isEmpty()) return;
    int i = rank(key);
    if (keys[i].compareTo(key) == 0) {
      exchange(keys, i, size - 1);
      exchange(values, i, size - 1);
      size -= 1;
    }
  }

  public boolean contains(Key key) {
    if (isEmpty()) return false;
    int i = rank(key);
    if (keys[i].compareTo(key) == 0) return true;
    return false;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    BinarySearchBasedSymbolTable<String, Integer> st = new BinarySearchBasedSymbolTable<>(6);
    st.put("hi", 2);
    st.put("hello", 3);
    st.put("where", 4);
    st.put("how", 5);
    st.put("there", 6);
    st.put("some", 7);
    System.out.println("hello");
  }
}
