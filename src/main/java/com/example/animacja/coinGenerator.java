package com.example.animacja;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

public class coinGenerator {
    Cylinder coin = new Cylinder();

    coinGenerator(){
        coin.setRadius(150);
        coin.setHeight(20);
        coin.setLayoutX(200);
        coin.setLayoutY(200);
        coin.setRotate(180);


    }
}
