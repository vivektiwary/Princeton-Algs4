package org.SymbolTable;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestLinkedListBasedSymbolTable {
  @Test
  public void testSymbolTableGet() {
    LinkedListBasedSymbolTable<String, Integer> st = new LinkedListBasedSymbolTable<>();
    assertEquals(st.size(), 0);
    st.put("hello", 1);
    st.put("hi", 2);
    st.put("how", 3);
    st.put("when", 4);
    assertEquals(st.get("hi"), (Integer) 2);
    assertEquals(st.size(), 4);
  }

  @Test
  public void testSymbolTableDelete() {
    LinkedListBasedSymbolTable<String, Integer> st = new LinkedListBasedSymbolTable<>();
    st.put("hello", 1);
    st.put("hi", 2);
    st.put("how", 3);
    st.put("when", 4);
    st.delete("how");
    assertFalse(st.contains("how"));
    assertEquals(st.size(), 4);
  }
}
