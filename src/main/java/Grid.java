package main.java;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Tooltip;
import javafx.scene.Node;

import static main.java.Constants.WINDOW_WIDTH;
import static main.java.Constants.WINDOW_HEIGHT;

public class Grid extends BorderPane {
    private Pane canvas;
    private ConvexHullManager convexHull;
    private Tooltip toolTip;

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
