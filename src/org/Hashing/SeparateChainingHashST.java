package org.Hashing;

public class SeparateChainingHashST<Key, Value> {
  private static class Node {
    private Object key;
    private Object val;
    private Node next;

    Node(Object k, Object v, Node n) {
      key = k;
      val = v;
      next = n;
    }
  }

  private int m = 5;
  private Node[] st = new Node[m];

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }

  public Value get(Key key) {
    int i = hash(key);
    for (Node p = st[i]; p != null; p = p.next) {
      if (key.equals(p.key)) return (Value) p.val;
    }
    return null;
  }

  public void put(Key key, Value val) {
    int i = hash(key);
    for (Node p = st[i]; p != null; p = p.next) {
      if (key.equals(p.key)) {
        p.val = val;
        return;
      }
    }
    st[i] = new Node(key, val, st[i]);
  }

  public void delete(Key key) {
    int i = hash(key);
    Node p = st[i];

    if (key.equals(p.key)) {
      p = p.next;
      st[i] = p;
      return;
    }

    Node node = p;
    Node prev = node;
    while (node != null && !key.equals(node.key)) {
      prev = node;
      node = node.next;
    }
    if (node == null) return;

    if (key.equals(node.key)) {
      prev.next = node.next;
    }
  }

  public static void main(String[] args) {
    SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
    st.put("aA", 8);
    st.put("bB", 10);
    st.put("bbaA", 12);
    st.put("aaBBAA", 14);
    st.put("aaBBaaA", 16);
    st.delete("bbaA");
    System.out.println("hello");
  }
}
