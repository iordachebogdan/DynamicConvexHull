package main.java;

import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

import static main.java.Constants.*;

public class Point extends Circle implements Comparable<Point> {
    public final double x, y;
    private boolean removeCounter;

    public Point(double x, double y) {
        super(x, y, POINT_RADIUS);
        super.setFill(ACTIVE_POINT_COLOR);
        this.x = x;
        this.y = y;
        this.resetRemoveCounter();
    }

    public void resetRemoveCounter() {
        this.removeCounter = true;
    }

    public void remove() {
        if (!this.removeCounter) {
            super.setFill(INACTIVE_POINT_COLOR);
        } else {
            this.removeCounter = false;
        }
        // if (super.getParent() instanceof Pane) {
        //     ((Pane) super.getParent()).getChildren().remove(this);
        // }
    }

    @Override
    public String toString() {
        return "Point{x=" + x + ", y=" + y + "}";
    }

    @Override
    public int compareTo(Point other) {
        final double xdif = x - other.x;
        final double ydif = y - other.y;
        if (xdif > EPS || xdif > -EPS && ydif > EPS) {
            return 1;
        }
        if (xdif < -EPS || ydif < -EPS) {
            return -1;
        }
        return 0;
    }
}
