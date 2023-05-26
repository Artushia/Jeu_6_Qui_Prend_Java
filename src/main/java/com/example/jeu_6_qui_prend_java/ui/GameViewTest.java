package com.example.jeu_6_qui_prend_java.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameViewTest {

    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);

        // Create four empty rectangles
        for (int i = 0; i < 4; i++) {
            Rectangle rectangle = new Rectangle(100, 50);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeWidth(1);
            GridPane.setRowIndex(rectangle, i);
            gridPane.getChildren().add(rectangle);
        }

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100);
        gridPane.getColumnConstraints().add(columnConstraints);

        Scene scene = new Scene(gridPane, 200, 300, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectangle Column");
        primaryStage.show();
    }

}


