package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.Card;
import com.example.jeu_6_qui_prend_java.Model.CardSet;
import com.example.jeu_6_qui_prend_java.Model.Cards;
import com.example.jeu_6_qui_prend_java.Model.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Le6QuiPrendApplication {

    Random random = new Random();
    List<Card> startcards = Cards.initialiseGameBoard(random);
    List<CardSet> playerCardList = Cards.distributeRandomCards(2, random, 10); // distribute 10 cards to each player
    Player player1 = new Player(1, playerCardList.get(0),11,true, null);
    Player player2 = new Player(2, playerCardList.get(1),22,false, null);

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

    public Text playerName;
    public Text playerPoint;

    public Button FinishTurnButton;
    public Player currentPlayer;

    private Rectangle twinklingCard;

    Card chosenCard;

    //Sets the cards at the beginning of the columns when game starts
    public void displayInitCards() {

        Rectangle[] firstRectangles = { jeu1, jeu7, jeu13, jeu19 };

        for (int i = 0; i < firstRectangles.length; i++) {
            Image image = CardImages.getFrontImage(startcards.get(i));
            ImagePattern imagePattern = new ImagePattern(image);
            firstRectangles[i].setFill(imagePattern);
        }

        System.out.println(startcards);

    }

    //When finish turn button is clicked, it switches active player
    //Stops twinkle effect when turn changes
    public void finishTurnButtonClicked() {

        if (player1.isPlayerturn()) {
            player1.setPlayerturn(false);
            player2.setPlayerturn(true);
            playerName.setText("Player turn: player " + player2.getPlayerNumber());
            playerPoint.setText(String.valueOf(player2.getPlayerScore()));
        } else {
            player1.setPlayerturn(true);
            player2.setPlayerturn(false);
            playerName.setText("Player turn: player " + player1.getPlayerNumber());
            playerPoint.setText(String.valueOf(player1.getPlayerScore()));
        }
        if (chosenCard != null) {
            Rectangle[] mainRectangles = { main1, main2, main3, main4, main5, main6, main7, main8, main9, main10 };

            System.out.println("player" + currentPlayer.getPlayerNumber() + " chose card: " + chosenCard);
            CardSet cardSet = currentPlayer.getPlayerCardSet();
            cardSet.take(chosenCard);
            System.out.println("player" + currentPlayer.getPlayerNumber() + " cardset: " + cardSet);
            chosenCard = null; // Reset the chosen card
            currentPlayer.setPlayerCardSet(cardSet);

            // Clear the remaining main rectangles
            for (int i = cardSet.remains().size(); i < mainRectangles.length; i++) {
                mainRectangles[i].setFill(null);
                mainRectangles[i].setUserData(null);
                mainRectangles[i].setOnMouseClicked(null);
            }

            // Update the main rectangles' userData and on-click event handlers
            for (int i = 0; i < cardSet.remains().size(); i++) {
                Image image = CardImages.getFrontImage(cardSet.getCard(i));
                ImagePattern imagePattern = new ImagePattern(image);

                // Set the fill and user data for the main rectangle
                mainRectangles[i].setFill(imagePattern);
                mainRectangles[i].setUserData(i); // Set the index as the user data of the button

                final int index = i;
                mainRectangles[i].setOnMouseClicked(e -> handleCardClick(index));
            }
        }
        displayInitHand();
        stopTwinkleEffect();


    }

    //Displays starting hand of player
        public void displayInitHand() {
        try {
            if (player1.isPlayerturn()) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }

            // Define an array to hold the main rectangles
            Rectangle[] mainRectangles = { main1, main2, main3, main4, main5, main6, main7, main8, main9, main10 };

            for (int i = 0; i < currentPlayer.getPlayerCardSet().remains().size(); i++) {
                Image image = CardImages.getFrontImage(currentPlayer.getPlayerCardSet().getCard(i));
                ImagePattern imagePattern = new ImagePattern(image);

                // Set the fill and user data for the main rectangle
                mainRectangles[i].setFill(imagePattern);
                mainRectangles[i].setUserData(i); // Set the index as the user data of the button
                // Create a final copy of the index variable
                final int index = i;

                // Set the on-click event handler for the main rectangle
                mainRectangles[i].setOnMouseClicked(e -> {
                            handleCardClick(index);
                            System.out.println("Clicked card: " + currentPlayer.getPlayerCardSet().getCard(index));
                            chosenCard = currentPlayer.getPlayerCardSet().getCard(index);
                            currentPlayer.setChosenCard(chosenCard);
                        }
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private Rectangle getCardRectangle(CardSet cardSet, Card chosenCard) {
        // Implement the mapping between card data and Rectangle objects
        Rectangle cardRectangle = null;

        List<Rectangle> cardRectangles = Arrays.asList(
                main1, main2, main3, main4, main5, main6, main7, main8, main9, main10
        );

        int index = cardSet.getCardIndex(chosenCard);
        if (index >= 0 && index < cardRectangles.size()) {
            cardRectangle = cardRectangles.get(index);
        }

        return cardRectangle;
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

    //Start Twinkle animation on card
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

    //Stops Twinkle animation on card
    private void stopTwinkleEffect() {
        if (twinklingCard != null) {
            twinklingCard.setEffect(null); // Remove the twinkle effect from the currently twinkling card
            twinklingCard = null; // Reset the twinkling card variable
        }
    }

}
