package com.example.animacja;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.control.Button;
import javafx.scene.input.RotateEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();

        coinGenerator coinGenerator = new coinGenerator();
        Cylinder coin = coinGenerator.coin;
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.GOLD);
        coin.setMaterial(material);
        root.getChildren().addAll(coin);


        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setDuration(Duration.seconds(8));
        rotateTransition.setNode(coin);
        rotateTransition.setAxis(Rotate.X_AXIS);
        rotateTransition.setRate(3);
        rotateTransition.setByAngle(360);


        rotateTransition.setCycleCount(Transition.INDEFINITE);
        rotateTransition.setAutoReverse(false);



        Button btnStart = new Button();
        btnStart.setLayoutX(80);
        btnStart.setLayoutY(400);
        btnStart.setText("START");

        Button btnStop = new Button();
        btnStop.setLayoutX(160);
        btnStop.setLayoutY(400);
        btnStop.setText("STOP");

        Button btnOne = new Button();
        btnOne.setLayoutX(230);
        btnOne.setLayoutY(400);
        btnOne.setText("STEP");

        Button btnReset = new Button();
        btnReset.setLayoutX(120);
        btnReset.setLayoutY(440);
        btnReset.setText("RESET POSITION");

        btnStart.setOnMouseClicked(mouseEvent -> {
            rotateTransition.play();

        });
        btnStop.setOnMouseClicked(mouseEvent -> {
            rotateTransition.stop();
        });
        btnOne.setOnMouseClicked(mouseEvent -> {
            coin.setRotationAxis(Rotate.X_AXIS);
            coin.setRotate(coin.getRotate()+3.6);
        });
        btnReset.setOnMouseClicked(mouseEvent -> {
            coin.setRotate(180);
        });



        root.getChildren().addAll(btnStart, btnStop, btnOne, btnReset);
        Scene scene = new Scene(root, 400, 500);
        scene.setFill(Color.AQUAMARINE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}