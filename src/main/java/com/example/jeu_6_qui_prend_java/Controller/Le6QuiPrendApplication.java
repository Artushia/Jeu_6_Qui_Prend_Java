package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.Card;
import com.example.jeu_6_qui_prend_java.Model.CardSet;
import com.example.jeu_6_qui_prend_java.Model.Cards;
import com.example.jeu_6_qui_prend_java.Model.Player;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Random;


public class Le6QuiPrendApplication {
    Random random = new Random();
    List<Card> cardtotal = Cards.cards;
    List<Card> initalcard = Cards.initialiseGameBoard(new Random());
    List<CardSet> playerCardList = Cards.distributeRandomCards(2, random, 10);
    Player player1 = new Player(1, playerCardList.get(0),0,true);
    Player player2 = new Player(2, playerCardList.get(1),0,false);

    public Rectangle jeu1;
    public Rectangle jeu2;
    public Rectangle jeu3;
    public Rectangle jeu4;
    public Rectangle jeu5;
    public Rectangle jeu6;
    public Rectangle jeu7;
    public Rectangle jeu8;
    public Rectangle jeu9;
    public Rectangle jeu10;
    public Rectangle jeu11;
    public Rectangle jeu12;
    public Rectangle jeu13;
    public Rectangle jeu14;
    public Rectangle jeu15;
    public Rectangle jeu16;
    public Rectangle jeu17;
    public Rectangle jeu18;
    public Rectangle jeu19;
    public Rectangle jeu20;
    public Rectangle jeu21;
    public Rectangle jeu22;
    public Rectangle jeu23;
    public Rectangle jeu24;

    public Rectangle main1;
    public Rectangle main2;
    public Rectangle main3;
    public Rectangle main4;
    public Rectangle main5;
    public Rectangle main6;
    public Rectangle main7;
    public Rectangle main8;
    public Rectangle main9;
    public Rectangle main10;


    public ImageView vuejeu1;
    public ImageView vuejeu2;
    public ImageView vuejeu3;
    public ImageView vuejeu4;
    public ImageView vuejeu5;
    public ImageView vuejeu6;
    public ImageView vuejeu7;
    public ImageView vuejeu8;
    public ImageView vuejeu9;
    public ImageView vuejeu10;
    public ImageView vuejeu11;
    public ImageView vuejeu12;
    public ImageView vuejeu13;
    public ImageView vuejeu14;
    public ImageView vuejeu15;
    public ImageView vuejeu16;
    public ImageView vuejeu17;
    public ImageView vuejeu18;
    public ImageView vuejeu19;
    public ImageView vuejeu20;
    public ImageView vuejeu21;
    public ImageView vuejeu22;
    public ImageView vuejeu23;
    public ImageView vuejeu24;
    public Text playerName;
    public Text playerPoint;

    public Button FinishTrunButton;

    public void displayInitCards() {

        System.out.println(initalcard);
        vuejeu1.setImage(CardImages.getFrontImage(initalcard.get(0)));
        vuejeu7.setImage(CardImages.getFrontImage(initalcard.get(1)));
        vuejeu13.setImage(CardImages.getFrontImage(initalcard.get(2)));
        vuejeu19.setImage(CardImages.getFrontImage(initalcard.get(3)));
    }
    public void finishTurnButtonClicked() {
        // Switch the active player
        if (player1.isPlayerturn()) {
            player1.setPlayerturn(false);
            player2.setPlayerturn(true);
            playerName.setText("Player turn: player " + player2.getPlayerNumber());
            playerPoint.setText(String.valueOf(player1.getPlayerScore()));
            displayInitHand();
        } else {
            player1.setPlayerturn(true);
            player2.setPlayerturn(false);
            playerName.setText("Player turn: player " + player1.getPlayerNumber());
            playerPoint.setText(String.valueOf(player2.getPlayerScore()));
            displayInitHand();
        }
    }
    public void displayInitHand() {
        try {
            System.out.println(playerCardList.get(0));
            Player currentPlayer;
            if (player1.isPlayerturn()) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            for (int i = 0; i < 10; i++) {
                Image image = CardImages.getFrontImage(currentPlayer.getPlayerCardSet().get(0).getCard(i));
                ImagePattern imagePattern = new ImagePattern(image);
                switch (i) {
                    case 0:
                        main1.setFill(imagePattern);
                        break;
                    case 1:
                        main2.setFill(imagePattern);
                        break;
                    case 2:
                        main3.setFill(imagePattern);
                        break;
                    case 3:
                        main4.setFill(imagePattern);
                        break;
                    case 4:
                        main5.setFill(imagePattern);
                        break;
                    case 5:
                        main6.setFill(imagePattern);
                        break;
                    case 6:
                        main7.setFill(imagePattern);
                        break;
                    case 7:
                        main8.setFill(imagePattern);
                        break;
                    case 8:
                        main9.setFill(imagePattern);
                        break;
                    case 9:
                        main10.setFill(imagePattern);
                        break;
                    default:
                        break;
                }
            }




            // 코드에서 발생할 수 있는 다른 작업 수행
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}

