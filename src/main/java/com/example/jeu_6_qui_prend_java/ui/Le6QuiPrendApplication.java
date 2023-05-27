package com.example.jeu_6_qui_prend_java.ui;

import com.example.jeu_6_qui_prend_java.Model.Card;
import com.example.jeu_6_qui_prend_java.Model.Cards;
import com.example.jeu_6_qui_prend_java.ui.card.CardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Le6QuiPrendApplication extends Application {
    Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        GameAcceuil();
    }
    public void GameAcceuil() {
        BorderPane mainBorderPanel = new BorderPane();

        GameAcceuil gameAcceuil = new GameAcceuil();
        mainBorderPanel.setCenter(gameAcceuil.getComponent());
        gameAcceuil.welcomeButton.setOnAction(e -> {
            GameView();
        });

        Scene scene = new Scene(mainBorderPanel, 1400, 800);
        stage.setScene(scene);
        stage.show();
    }
    public void GameView()  {
        BorderPane mainBorderPanel = new BorderPane();

        VBox menuAndToolbar = new VBox();
        { // MenuBar with "File" menu
            MenuBar mb = new MenuBar();
            menuAndToolbar.getChildren().add(mb);

            Menu fileMenu = new Menu("File");
            mb.getMenus().add(fileMenu);
            MenuItem openMenuItem = new MenuItem("Open");
            fileMenu.getItems().add(openMenuItem);
            MenuItem saveMenuItem = new MenuItem("Save");
            fileMenu.getItems().add(saveMenuItem);
        }

        { // button Toolbar
            ToolBar toolBar = new ToolBar();
            menuAndToolbar.getChildren().add(toolBar);

            Button button1 = new Button("button1");
            toolBar.getItems().add(button1);
        }
        mainBorderPanel.setTop(menuAndToolbar);

        GameView gameView = new GameView();
        List<CardView> player1Hand = gameView.getPlayer1Hand();
        List<CardView> player2Hand = gameView.getPlayer2Hand();

        List<Card> allCards = new ArrayList<>(Cards.cards);
        Collections.shuffle(allCards);

        int cardCount = 0;
        for (Card card : allCards) {
            if (cardCount < 10) {
                if (cardCount % 2 == 0) {
                    player1Hand.add(new CardView(card, gameView.cardWidth, gameView.cardHeight));
                } else {
                    player2Hand.add(new CardView(card, gameView.cardWidth, gameView.cardHeight));
                }
                cardCount++;
            } else {
                break;
            }
        }
        mainBorderPanel.setCenter(gameView.getComponent());

        Scene scene = new Scene(mainBorderPanel, 1400, 800);
        stage.setScene(scene);
        stage.show();
    }

}
