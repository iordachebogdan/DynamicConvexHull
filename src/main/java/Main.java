package main.java;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static main.java.Constants.WINDOW_WIDTH;
import static main.java.Constants.WINDOW_HEIGHT;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("Dynamic Convex Hull");
        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.setResizable(false);

        Grid grid = new Grid();
        root.getChildren().add(grid);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
