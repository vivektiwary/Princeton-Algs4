package org.UndirectedGraphs;

public class ConnectedComponent {
  private boolean[] marked;
  private int[] id;
  private int counter = 0;

  public ConnectedComponent(Graph g) {
    marked = new boolean[g.V()];
    id = new int[g.V()];

    for (int x = 0; x < g.V(); x += 1) {
      if (!marked[x]) {
        dfs(g, x);
        counter += 1;
      }
    }
  }

  private void dfs(Graph g, int s) {
    marked[s] = true;
    id[s] = counter;
    for (int w : g.adj(s)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
  }

  public boolean connected(int v, int w) {
    return id[v] == id[w];
  }

  public int count() {
    // no of connected components
    return counter;
  }

  public int id(int v) {
    // component identifier for v
    return id[v];
  }

  public static void main(String[] args) {
    UndirectedGraph ug = new UndirectedGraph(10);
    ug.addEdge(0, 1);
    ug.addEdge(0, 2);
    ug.addEdge(0, 3);

    ug.addEdge(4, 5);
    ug.addEdge(6, 7);
    ug.addEdge(6, 8);
    ug.addEdge(8, 9);
    ug.addEdge(9, 6);

    ConnectedComponent cc = new ConnectedComponent(ug);
    System.out.println(cc.connected(0, 4));
    System.out.println(cc.connected(0, 3));
    System.out.println(cc.connected(4, 6));
    System.out.println(cc.connected(9, 6));
  }
}
