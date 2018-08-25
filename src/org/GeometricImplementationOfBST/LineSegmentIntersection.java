package org.GeometricImplementationOfBST;

import org.Trees.BinarySearchTree;

public class LineSegmentIntersection {
  private PriorityQueueForLineSegmentIntersection pq;
  private BinarySearchTree<Integer, Integer> bst;

  public LineSegmentIntersection(int capacity) {
    pq = new PriorityQueueForLineSegmentIntersection(capacity);
    bst = new BinarySearchTree<>();
  }

  public void insertLine(Line l) {
    pq.insert(l);
  }

  public void printIntersection() {

  }

  public static void main(String[] args) {
//    LineSegmentIntersection lineSegmentIntersection = new LineSegmentIntersection();
  }
}
