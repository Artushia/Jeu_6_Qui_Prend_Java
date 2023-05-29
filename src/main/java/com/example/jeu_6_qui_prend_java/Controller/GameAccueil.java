package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.Card;
import com.example.jeu_6_qui_prend_java.Model.Cards;
//import com.example.jeu_6_qui_prend_java.View.CardView;
import com.example.jeu_6_qui_prend_java.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.Random;

@Slf4j
public class GameAccueil {

    public Button startButton;

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/jeu_6_qui_prend_java/mainPage.fxml"));
        Parent secondPage = loader.load();
        Scene scene = new Scene(secondPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        Le6QuiPrendApplication mainPageController = loader.getController();
        mainPageController.displayInitCards();
        mainPageController.displayInitHand();
        mainPageController.finishTurnButtonClicked();
        // Register the button's action event handler
        mainPageController.FinishTrunButton.setOnAction(e -> {
            mainPageController.finishTurnButtonClicked();
        });
    }

}
