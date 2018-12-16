package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
//        ConvexHullManager chm = new ConvexHullManager();
//
//        chm.add(new Point(1, 0));
//        chm.add(new Point(0, 0));
//        chm.add(new Point(1, 1));
//        chm.add(new Point(0.1, 0.1));
//
//        for (var p : chm.activePoints) {
//            System.out.println(p.toString());
//        }

        Group root = new Group();
        primaryStage.setTitle("Dynamic Convex Hull");
        primaryStage.setScene(new Scene(root, 500, 500));

        Grid grid = new Grid();
        root.getChildren().add(grid);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
