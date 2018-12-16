package main.java;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Dynamic Convex Hull");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable(false);

        Grid grid = new Grid();
        root.getChildren().add(grid);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
