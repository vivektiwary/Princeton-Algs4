package org.UndirectedGraphs;

import java.util.Stack;

public class DepthFirstSearch {
  private Boolean[] marked;
  private int[] edgeTo;
  private int s;

  public DepthFirstSearch(Graph g, int s) {
    this.s = s;
    marked = new Boolean[g.V()];
    edgeTo = new int[g.V()];

    for (int w = 0; w < g.V(); w += 1) {
      marked[w] = false;
    }
    dfs(g, s);
  }

  private void dfs(Graph g, int s) {
    marked[s] = true;
    for (int w : g.adj(s)) {
      if (!marked[w]) {
        dfs(g, w);
        edgeTo[w] = s;
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }

  public static void main(String[] args) {
    UndirectedGraph ug = new UndirectedGraph(6);
    ug.addEdge(0, 1);
    ug.addEdge(0, 2);
    ug.addEdge(0, 3);
    ug.addEdge(0, 5);
    ug.addEdge(3, 4);
    ug.addEdge(3, 5);

    DepthFirstSearch dfs = new DepthFirstSearch(ug, 0);
    for (int w : dfs.pathTo(4)) {
      System.out.println(w);
    }
  }
}
