package org.DirectedGraph;

import org.LinkedList.Bag;
import org.UndirectedGraphs.Graph;

public class Digraph implements Graph {
  private final int V;
  private int E;
  private Bag<Integer>[] adj;

  public Digraph(int V) {
    this.V = V;
    adj = (Bag<Integer>[]) new Bag[V];
    for (int i = 0; i < V; i += 1) {
      adj[i] = new Bag<>();
    }
    E = 0;
  }

  @Override
  public void addEdge(int v, int w) {
    adj[v].add(w);
    E += 1;
  }

  @Override
  public int V() {
    return V;
  }

  @Override
  public int E() {
    return E;
  }

  @Override
  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  public static void main(String[] args) {
    Digraph dg = new Digraph(6);
    dg.addEdge(0, 1);
    dg.addEdge(0, 2);
    dg.addEdge(0, 3);
    dg.addEdge(0, 5);
    dg.addEdge(3, 4);
    dg.addEdge(3, 5);

    for (int i = 0; i < dg.V(); i += 1) {
      for (int w : dg.adj(i)) {
        System.out.println(i + " -- " + w);
      }
    }
  }
}
