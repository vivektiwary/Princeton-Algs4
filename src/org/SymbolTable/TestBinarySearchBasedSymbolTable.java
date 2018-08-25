package org.SymbolTable;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBinarySearchBasedSymbolTable {
  @Test
  public void testPut() {
    BinarySearchBasedSymbolTable<String, Integer> st = new BinarySearchBasedSymbolTable<>(6);

    assertTrue(st.isEmpty());
    st.put("hi", 2);
    st.put("hello", 3);
    st.put("where", 4);
    st.put("how", 5);
    st.put("there", 6);
    st.put("some", 7);

    assertEquals(st.size(), 6);
  }

  @Test
  public void testGet() {
    BinarySearchBasedSymbolTable<String, Integer> st = new BinarySearchBasedSymbolTable<>(6);

    st.put("hi", 2);
    st.put("hello", 3);
    st.put("where", 4);
    st.put("how", 5);
    st.put("there", 6);
    st.put("some", 7);

    assertEquals(st.get("hi"), (Integer) 2);
    assertNull(st.get("someone"));
  }

  @Test
  public void testContains() {
    BinarySearchBasedSymbolTable<String, Integer> st = new BinarySearchBasedSymbolTable<>(6);

    st.put("hi", 2);
    st.put("hello", 3);
    st.put("where", 4);
    st.put("how", 5);
    st.put("there", 6);
    st.put("some", 7);

    assertTrue(st.contains("how"));
    assertFalse(st.contains("when"));
  }

  @Test
  public void testDelete() {
    BinarySearchBasedSymbolTable<String, Integer> st = new BinarySearchBasedSymbolTable<>(6);

    st.put("hi", 2);
    st.put("hello", 3);
    st.put("where", 4);
    st.put("how", 5);
    st.put("there", 6);
    st.put("some", 7);

    assertEquals(st.size(), 6);
    st.delete("how");
    assertEquals(st.size(), 5);
    assertFalse(st.contains("how"));
  }
}
