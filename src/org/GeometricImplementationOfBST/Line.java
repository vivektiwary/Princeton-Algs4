package org.GeometricImplementationOfBST;

public class Line implements Comparable {
  private class Point {
    private int xCoord;
    private int yCoord;

    Point(int x, int y) {
      xCoord = x;
      yCoord = y;
    }
  }

  private Point start;
  private Point end;

  public Line(int startX, int startY, int endX, int endY) {
    start = new Point(startX, startY);
    end = new Point(endX, endY);
  }

  public int getxCoord(Point p) {
    return p.xCoord;
  }

  public int getyCoord(Point p) {
    return p.yCoord;
  }

  @Override
  public int compareTo(Object o) {
    Line l = (Line) o;
//    return xCoord - l.xCoord;
    return 0;
  }
}
