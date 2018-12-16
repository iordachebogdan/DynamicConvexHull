package main.java;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Grid extends Region {
    public Grid() {
        Canvas canvas = new Canvas(500, 500);
        this.getChildren().add(canvas);
        canvas.setOnMouseClicked(canvasOnMouseClicked);
    }

    private final double radius = 10;

    private EventHandler<MouseEvent> canvasOnMouseClicked = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getSource() instanceof Canvas) {
                Canvas canvas = (Canvas)e.getSource();
                GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

                double x = e.getX();
                double y = e.getY();
                graphicsContext.setFill(Color.BLACK);
                graphicsContext.fillOval(x - radius, y - radius, radius, radius);
            }
        }
    };
}
