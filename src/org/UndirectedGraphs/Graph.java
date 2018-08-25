package org.UndirectedGraphs;

public interface Graph {
  void addEdge(int v, int w);
  Iterable<Integer> adj(int v);
  int V(); // number of vertices
  int E(); // number of edges

  default int degree(Graph g, int v) {
    int degree = 0;
    for (int w : g.adj(v))  degree += 1;
    return degree;
  }

  default int maxDegree(Graph g) {
    int maxDegree = 0;
    for (int i = 0; i < g.V(); i += 1) {
      int degree = degree(g, i);
      if (degree > maxDegree) {
        maxDegree = degree;
      }
    }
    return maxDegree;
  }

  default double avgDegree(Graph g) {
    return (2.0 * g.E() / g.V());
  }

  default int numberOfSelfLoops(Graph g) {
    int count = 0;
    for (int v = 0; v < g.V(); v += 1) {
      for (int w : g.adj(v)) {
        if (v == w) count += 1;
      }
    }
    return count / 2; // each edge counted twice
  }
}
