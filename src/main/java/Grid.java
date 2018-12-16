package main.java;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Grid extends BorderPane {
    public Grid() {
        Pane canvas = new Pane();
        canvas.setPrefSize(500, 500);
        this.setCenter(canvas);
        canvas.setOnMouseClicked(canvasOnMouseClicked);
    }

    private ConvexHullManager ch = new ConvexHullManager();

    private EventHandler<MouseEvent> canvasOnMouseClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getSource() instanceof Pane) {
                Pane canvas = (Pane)e.getSource();

                double x = e.getX();
                double y = e.getY();
                Point newPoint = new Point(x, y);
                canvas.getChildren().add(newPoint);
                ch.add(newPoint);
                System.out.println("Hit canvas");
            }
        }
    };

    private EventHandler<MouseEvent> circleOnMouseClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getSource() instanceof Circle) {
                System.out.println("Hit circle");
                e.consume();
            }
        }
    };
}
