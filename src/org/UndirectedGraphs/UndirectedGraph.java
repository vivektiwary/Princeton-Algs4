package org.UndirectedGraphs;

import org.LinkedList.Bag;

public class UndirectedGraph implements Graph {
  private final int V;
  private int E;
  private Bag<Integer> [] adj;

  public UndirectedGraph(int V) {
    this.V = V;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int i = 0; i < V; i += 1) {
      adj[i] = new Bag<>();
    }
  }

  @Override
  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    E += 1;
  }

  @Override
  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  @Override
  public int V() {
    return V;
  }

  @Override
  public int E() {
    return E;
  }

  public static void main(String[] args) {
    UndirectedGraph ug = new UndirectedGraph(6);
    ug.addEdge(0, 1);
    ug.addEdge(0, 2);
    ug.addEdge(0, 3);
    ug.addEdge(0, 5);
    ug.addEdge(3, 4);
    ug.addEdge(3, 5);

    for (int i = 0; i < ug.V(); i += 1) {
      for (int w : ug.adj(i)) {
        System.out.println(i + " -- " + w);
      }
    }
  }
}
