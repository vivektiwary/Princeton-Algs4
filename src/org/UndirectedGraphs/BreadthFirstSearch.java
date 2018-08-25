package org.UndirectedGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
  private Boolean[] marked;
  private int[] edgeTo;
  private int s;

  public BreadthFirstSearch(Graph g, int s) {
    this.s = s;
    marked = new Boolean[g.V()];
    edgeTo = new int[g.V()];
    for (int i = 0; i < g.V(); i += 1) marked[i] = false;
    bfs(g, s);
  }

  private void bfs(Graph g, int s) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);

    marked[s] = true;
    while (!q.isEmpty()) {
      int v = q.remove();

      for (int w : g.adj(v)) {
        if (!marked[w]) {
          q.add(w);
          marked[w] = true;
          edgeTo[w] = v;
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x])
      path.push(x);

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

    BreadthFirstSearch dfs = new BreadthFirstSearch(ug, 0);
    for (int w : dfs.pathTo(4)) {
      System.out.println(w);
    }
  }
}
