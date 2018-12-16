package main.java;

import static main.java.Constants.EPS;

public class Point implements Comparable<Point> {
    public final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{x=" + x + ", y=" + y + "}";
    }

    @Override
    public int compareTo(Point other) {
        double xdif = x - other.x;
        double ydif = y - other.y;
        if (xdif > EPS || xdif > -EPS && ydif > EPS) {
            return 1;
        }
        if (xdif < -EPS || ydif < -EPS) {
            return -1;
        }
        return 0;
    }
}
