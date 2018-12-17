package main.java;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import static main.java.Constants.POINT_RADIUS;
import static main.java.Constants.ACTIVE_POINT_COLOR;
import static main.java.Constants.INACTIVE_POINT_COLOR;
import static main.java.Constants.EPS;

public class Point extends Circle implements Comparable<Point> {
    public final double x, y;
    private boolean setInactiveCounter;
    private Line lineToPrev = null;

    public Point(double x, double y, double screenX, double screenY) {
        super(screenX, screenY, POINT_RADIUS);
        super.setFill(ACTIVE_POINT_COLOR);
        super.setOnMouseClicked(e -> {
            if (e.getSource() instanceof Point) {
                e.consume();
            }
        });
        this.x = x;
        this.y = y;
        resetSetInactiveCounter();
    }

    public void resetSetInactiveCounter() {
        setInactiveCounter = true;
    }

    public void setInactive() {
        if (!this.setInactiveCounter) {
            super.setFill(INACTIVE_POINT_COLOR);
        } else {
            setInactiveCounter = false;
        }
    }

    public void remove() {
        if (super.getParent() instanceof Pane) {
            ((Pane) super.getParent()).getChildren().remove(this);
        }
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
