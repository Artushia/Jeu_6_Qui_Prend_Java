package com.example.jeu_6_qui_prend_java.ui;

import com.example.jeu_6_qui_prend_java.ui.card.CardImages;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
public class GameAcceuil {
    private BorderPane component;
    private Pane centerArea;

    Label endLabel;

    public Label welcomeText = new Label("Welcome to the Game 6 qui prend !");
    public Button welcomeButton = new Button("Start");


    //---------------------------------------------------------------------------------------------

    public GameAcceuil() {

    this.component = new BorderPane();
        centerArea = new Pane();
        VBox welcomeTextContainer = new VBox();
        welcomeTextContainer.getStyleClass().add("welcomeTextContainer");
        welcomeTextContainer.getChildren().add(welcomeText);

        VBox welcomeButtonContainer = new VBox();
        welcomeButtonContainer.getStyleClass().add("welcomeButtonContainer");
        welcomeButtonContainer.getChildren().add(welcomeButton);

        component.setTop(welcomeTextContainer);
        component.setBottom(welcomeButtonContainer);

    }

    //---------------------------------------------------------------------------------------------

    public Node getComponent() {
        return component;
    }

}
