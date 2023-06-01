package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.CardSet;
import com.example.jeu_6_qui_prend_java.Model.Cards;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class GameStart extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameStart.class.getResource("/com/example/jeu_6_qui_prend_java/welcomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1092 , 749);
        stage.setTitle("6 qui prend");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        String musicFile = "C:\\Users\\leona\\IdeaProjects\\TP\\demo\\Jeu_6_Qui_Prend_Java\\Jeu_6_Qui_Prend_Java\\Jeu_6_Qui_Prend_Java\\src\\main\\resources\\Music\\Musique_fond.mp3"; // Mettez le chemin d'accès à votre fichier audio ici
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        launch();
    }
}
