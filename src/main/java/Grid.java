package main.java;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Grid extends BorderPane {
    private Pane canvas;
    private ConvexHullManager ch;

    public Grid() {
        canvas = new Pane();
        ch = new ConvexHullManager();
        canvas.setPrefSize(500, 500);
        this.setCenter(canvas);
        canvas.setOnMouseClicked(e -> {
            if (e.getSource() instanceof Pane) {
                Pane canvas = (Pane)e.getSource();
                double x = e.getX();
                double y = e.getY();
                Point newPoint = new Point(x, y);
                canvas.getChildren().add(newPoint);
                ch.add(newPoint);
            }
        });
    }
}
