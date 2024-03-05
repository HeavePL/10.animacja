package com.example.animacja;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();

        Polygon pentagram = new Polygon();

        pentagram.getPoints().addAll(new Double[]{
                200.0, 50.0,
                300.0, 150.0,
                250.0, 250.0,
                150.0, 250.0,
                100.0, 150.0,
        });

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setNode(pentagram);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(-1);
        rotateTransition.setAutoReverse(false);

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(6000));
        scaleTransition.setNode(pentagram);
        scaleTransition.setByX(-2.5);
        scaleTransition.setByY(-2.5);
        scaleTransition.setCycleCount(-1);
        scaleTransition.setAutoReverse(false);
        
        scaleTransition.play();
        rotateTransition.play();

        pentagram.setFill(Color.AQUAMARINE);
        root.getChildren().add(pentagram);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}