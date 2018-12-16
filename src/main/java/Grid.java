package main.java;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Tooltip;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

import static main.java.Constants.WINDOW_WIDTH;
import static main.java.Constants.WINDOW_HEIGHT;

public class Grid extends BorderPane {
    private Pane canvas;
    private ConvexHullManager convexHull;
    private Tooltip toolTip;
    private double dragOriginX, dragOriginY;

    public Grid() {
        canvas = new Pane();
        convexHull = new ConvexHullManager();
        canvas.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setCenter(canvas);

        toolTip = new Tooltip();

        canvas.setOnMouseClicked(e -> {
            if (e.getSource() instanceof Pane) {
                Pane canvas = (Pane)e.getSource();
                double x = e.getX();
                double y = e.getY();
                Point newPoint = new Point(x, y);
                canvas.getChildren().add(newPoint);
                convexHull.add(newPoint);

                canvas.getChildren().removeIf(c -> c instanceof Line);
                var hull = convexHull.getConvexHull();
                for (int i = 0; i + 1 < hull.size(); ++i) {
                    Line line = new Line();
                    line.setStartX(hull.get(i).getCenterX());
                    line.setStartY(hull.get(i).getCenterY());
                    line.setEndX(hull.get(i+1).getCenterX());
                    line.setEndY(hull.get(i+1).getCenterY());
                    line.setFill(Color.BLUE);
                    line.setStrokeWidth(hull.get(i).getRadius() / 2.0);
                    canvas.getChildren().add(line);
                }
            }
        });

        canvas.setOnMouseMoved(e -> {  // @TODO(iordachebogdan) account for drag and zoom displacements (also ordinates seem to be inverted)
            toolTip.setText("{x: " + e.getX() + ", y: " + e.getY() + "}");
            toolTip.show((Node) e.getSource(), e.getScreenX() + 15, e.getScreenY() + 15);
        });
        canvas.setOnMouseExited(e -> {
            toolTip.hide();
        });
    }
}
