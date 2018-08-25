package org.GeometricImplementationOfBST;

public class PriorityQueueForLineSegmentIntersection {
  private Line[] items;
  private int size;

  public PriorityQueueForLineSegmentIntersection(int capacity) {
    items = new Line[capacity + 1];
    size = 0;
  }

  private void swim(int j) {
    while (j > 1 && less(j, j / 2)) {
      swap(j / 2, j);
      j = j / 2;
    }
  }

  private void sink(int j) {
    while (2 * j < size) {
      int childIndex = 2 * j;
      if (less(childIndex + 1, childIndex))  childIndex += 1;
      if (!less(childIndex, j))                 break;
      swap(childIndex, j);
      j = childIndex;
    }
  }

  private void swap(int i, int j) {
    Line temp = items[i];
    items[i] = items[j];
    items[j] = temp;
  }

  private boolean less(int i, int j) {
    return items[i].compareTo(items[j]) < 0;
  }

  public void insert(Line l) {
    items[++size] = l;
    swim(size);
  }

  public Line delMin() {
    Line item = items[1];
    items[1] = items[size];
    items[size--] = null;
    sink(1);
    return item;
  }

  public static void main(String[] args) {
    PriorityQueueForLineSegmentIntersection pq = new PriorityQueueForLineSegmentIntersection(6);

//    pq.insert(new Line(9, 10));
//    pq.insert(new Line(12, 13));
//    pq.insert(new Line(5, 6));
//    pq.insert(new Line(7, 14));
//    pq.insert(new Line(2, 5));
//    pq.insert(new Line(20, 30));
////    System.out.println(pq.delMin().getxCoord());
//    System.out.println(pq.delMin().getxCoord());
//    System.out.println(pq.delMin().getxCoord());
//    System.out.println(pq.delMin().getxCoord());
//    System.out.println(pq.delMin().getxCoord());
//    System.out.println(pq.delMin().getxCoord());
  }
}
