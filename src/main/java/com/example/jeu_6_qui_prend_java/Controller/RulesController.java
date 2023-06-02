package com.example.jeu_6_qui_prend_java.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RulesController {
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
        mainPageController.FinishTurnButton.setOnAction(e -> mainPageController.finishTurnButtonClicked());
    }
}