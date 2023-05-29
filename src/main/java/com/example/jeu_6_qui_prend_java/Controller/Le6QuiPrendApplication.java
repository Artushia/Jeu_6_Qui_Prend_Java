package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.Card;
import com.example.jeu_6_qui_prend_java.Model.CardSet;
import com.example.jeu_6_qui_prend_java.Model.Cards;
import com.example.jeu_6_qui_prend_java.Model.Player;
import javafx.animation.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Arrays;
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

    private Rectangle twinklingCard;

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
            stopTwinkleEffect(); // Stop the twinkle effect when the turn changes

        } else {
            player1.setPlayerturn(true);
            player2.setPlayerturn(false);
            playerName.setText("Player turn: player " + player1.getPlayerNumber());
            playerPoint.setText(String.valueOf(player2.getPlayerScore()));
            displayInitHand();
            stopTwinkleEffect(); // Stop the twinkle effect when the turn changes

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
            // Define an array to hold the main rectangles
            Rectangle[] mainRectangles = { main1, main2, main3, main4, main5, main6, main7, main8, main9, main10 };

            for (int i = 0; i < 10; i++) {
                Image image = CardImages.getFrontImage(currentPlayer.getPlayerCardSet().get(0).getCard(i));
                ImagePattern imagePattern = new ImagePattern(image);

                // Set the fill and user data for the main rectangle
                mainRectangles[i].setFill(imagePattern);
                mainRectangles[i].setUserData(i); // Set the index as the user data of the button

                // Create a final copy of the index variable
                final int index = i;

                // Set the on-click event handler for the main rectangle
                mainRectangles[i].setOnMouseClicked(e -> {
                        handleCardClick(index);
                    System.out.println("Clicked card: " + currentPlayer.getPlayerCardSet().get(0).getCard(index));
                        }
                );
            }


            // 코드에서 발생할 수 있는 다른 작업 수행
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void handleCardClick(int userData) {
        if (twinklingCard != null) {
            twinklingCard.setEffect(null); // Remove the twinkle effect from the currently twinkling card
        }
        Rectangle clickedCard = getCardRectangle(userData);
        applyTwinkleEffect(clickedCard);
    }


    private Rectangle getCardRectangle(int userData) {
        // Implement the mapping between card data and Rectangle objects
        Rectangle cardRectangle = null;

        // Assuming you have a list of Rectangle objects representing the cards
        List<Rectangle> cardRectangles = Arrays.asList(
                main1, main2, main3, main4, main5, main6, main7, main8, main9, main10
        );

        // Assuming the userData represents the index of the clicked card in the list
        if (userData >= 0 && userData < cardRectangles.size()) {
            cardRectangle = cardRectangles.get(userData);
        }

        return cardRectangle;
    }

    private void applyTwinkleEffect(Rectangle cardRectangle) {
        ColorAdjust colorAdjust = new ColorAdjust();
        cardRectangle.setEffect(colorAdjust);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(colorAdjust.brightnessProperty(), 0.0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(colorAdjust.brightnessProperty(), -0.6)),
                new KeyFrame(Duration.seconds(1.0), new KeyValue(colorAdjust.brightnessProperty(), 0.0))
        );

        timeline.setCycleCount(Animation.INDEFINITE); // Repeat the twinkle indefinitely
        timeline.play();

        twinklingCard = cardRectangle; // Assign the currently twinkling card
    }

    private void stopTwinkleEffect() {
        if (twinklingCard != null) {
            twinklingCard.setEffect(null); // Remove the twinkle effect from the currently twinkling card
            twinklingCard = null; // Reset the twinkling card variable
        }
    }




}

