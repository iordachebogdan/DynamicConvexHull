package main.java;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Grid extends BorderPane {
    public Grid() {
        Pane canvas = new Pane();
        canvas.setPrefSize(500, 500);
        this.setCenter(canvas);
        canvas.setOnMouseClicked(canvasOnMouseClicked);
    }

    private final double radius = 5;
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Circle> circles = new ArrayList<>();

    private EventHandler<MouseEvent> canvasOnMouseClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getSource() instanceof Pane) {
                Pane canvas = (Pane)e.getSource();

                double x = e.getX();
                double y = e.getY();
                Circle newPoint = new Circle(x, y, radius);
                newPoint.setFill(Color.BLACK);
                circles.add(newPoint);
                canvas.getChildren().add(newPoint);
            }
        }
    };
}
