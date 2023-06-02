package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.*;
import javafx.animation.*;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Le6QuiPrendApplication {

    Random random = new Random();
    List<Card> startcards = Cards.initialiseGameBoard(random);
    List<CardSet> playerCardList = Cards.distributeRandomCards(2, random, 10); // distribute 10 cards to each player
    public  Player player1 = new Player(1, playerCardList.get(0),0,true, null);
    public Player player2 = new Player(2, playerCardList.get(1),0,false, null);
    private static final Duration CARD_MOVE_DURATION = Duration.seconds(1);
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
    public CardStack CardSet1 = new CardStack(startcards.get(0));
    public CardStack CardSet2 = new CardStack(startcards.get(1));
    public CardStack CardSet3 = new CardStack(startcards.get(2));
    public CardStack CardSet4 = new CardStack(startcards.get(3));
    private Rectangle twinklingCard;

    Rectangle jeuUpdate;
    Rectangle jeuUpdate2;

    Card chosenCard;
    List<Integer> Topvalues = new ArrayList<>();

    //Sets the cards at the beginning of the columns when game starts
    public void displayInitCards() {

        Rectangle[] firstRectangles = { jeu1, jeu7, jeu13, jeu19 };

        for (int i = 0; i < firstRectangles.length; i++) {
            Image image = CardImages.getFrontImage(startcards.get(i));
            ImagePattern imagePattern = new ImagePattern(image);
            firstRectangles[i].setFill(imagePattern);
            playRotationAnimation(firstRectangles[i]); // Ajoutez cette ligne pour jouer l'animation de rotation
        }

        System.out.println("CardSet1: " + CardSet1.getTopValue());//
        System.out.println("CardSet2: " + CardSet2.getTopValue());//
        System.out.println("CardSet3: " + CardSet3.getTopValue());//
        System.out.println("CardSet4: " + CardSet4.getTopValue());//

        Topvalues.add(CardSet1.getTopValue());
        Topvalues.add(CardSet2.getTopValue());
        Topvalues.add(CardSet3.getTopValue());
        Topvalues.add(CardSet4.getTopValue());

        playerName.setText("Player turn: player " + player1.getPlayerNumber());
        playerPoint.setText(String.valueOf(player1.getPlayerScore()));
    }

    private void playRotationAnimation(Rectangle rectangle) {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), rectangle);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }

    //When finish turn button is clicked, it switches active player
    //Stops twinkle effect when turn changes
    public void finishTurnButtonClicked() {
        int minDifferenceP1 = Integer.MAX_VALUE; // Initialize the minimum difference with a large value
        int minDifferenceP2 = Integer.MAX_VALUE; // Initialize the minimum difference with a large value

        Rectangle[] firstRectangles = { jeu1, jeu7, jeu13, jeu19 };

        Rectangle[] firstStackRectangles = { jeu2, jeu3, jeu4, jeu5, jeu6 };
        Rectangle[] secondStackRectangles = { jeu8, jeu9, jeu10, jeu11, jeu12 };
        Rectangle[] thirdStackRectangles = { jeu14, jeu15, jeu16, jeu17, jeu18 };
        Rectangle[] fourthStackRectangles = { jeu20, jeu21, jeu22, jeu23, jeu24 };

        Rectangle[] mainRectangles = { main1, main2, main3, main4, main5, main6, main7, main8, main9, main10 };

        if (player1.isPlayerturn()) {
            player1.setPlayerturn(false);
            player2.setPlayerturn(true);
            playerName.setText("It's Player " + player2.getPlayerNumber() + "'s time to play ");
            playerPoint.setText(String.valueOf(player2.getPlayerScore()));
        } else {
            player1.setPlayerturn(true);
            player2.setPlayerturn(false);
            playerName.setText("It's Player " + player1.getPlayerNumber() + "'s time to play ");
            playerPoint.setText(String.valueOf(player1.getPlayerScore()));
        }
        if (chosenCard != null) {
            System.out.println("player" + currentPlayer.getPlayerNumber() + " chose card: " + chosenCard);
            CardSet cardSet = currentPlayer.getPlayerCardSet();
            cardSet.take(chosenCard); // remove the chosen card from the player's card set
            System.out.println("player" + currentPlayer.getPlayerNumber() + " cardset: " + cardSet);
            if(player1.getChosenCard() != null && player2.getChosenCard() != null){
                int indexP1 = 0; // Initialize the index of the minimum difference
                int indexP2 = 0; // Initialize the index of the minimum difference
                for (int i = 0; i < Topvalues.size(); i++) {
                    int differenceP1 = player1.getChosenCard().value - Topvalues.get(i) ; // player1's difference
                    int differenceP2 = player2.getChosenCard().value - Topvalues.get(i) ; // player2's difference
                    System.out.println("DifferenceP1 for index " + i + ": " + differenceP1);
                    System.out.println("DifferenceP2 for index " + i + ": " + differenceP2);
                    // Update the minimum difference if the current difference is smaller
                    if (differenceP1 >0 && differenceP1 < minDifferenceP1) {
                        minDifferenceP1 = differenceP1;
                        indexP1 = i;
                    }
                    if (differenceP2 >0 && differenceP2 < minDifferenceP2) {
                        minDifferenceP2 = differenceP2;
                        indexP2 = i;
                    }

                }
                System.out.println("IndexP1: " + indexP1);
                System.out.println("IndexP2: " + indexP2);

                //Move the chosen card to the right stack
                if(indexP1 == indexP2){
                    if(minDifferenceP1 < minDifferenceP2){
                        switch (indexP1){
                            case 0:
                                CardSet1.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet1.getCardCount() > 1){
                                    // jeuUpdate is for player1 and jeuUpdate2 is for player2
                                    jeuUpdate = firstStackRectangles[CardSet1.getCardCount() - 2];
                                    // -2 because it start 0 for index and firstStackRectangles[0] is for the second card
                                    if(CardSet1.getCardCount() == 5){
                                        CardSet1.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate2 = firstRectangles[0];
                                        for (int i = 0; i < 4; i++) {
                                            firstStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet1.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = firstStackRectangles[CardSet1.getCardCount() - 2];
                                }else{
                                    jeuUpdate = firstRectangles[0];
                                    for (int i = 0; i < 4; i++) {
                                        firstStackRectangles[i].setFill(null);
                                    }
                                    CardSet1.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = firstStackRectangles[CardSet1.getCardCount() - 2];
                                }
                                break;
                            case 1:
                                CardSet2.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet2.getCardCount() > 1){
                                    jeuUpdate = secondStackRectangles[CardSet2.getCardCount() - 2];
                                    if(CardSet2.getCardCount() == 5){
                                        CardSet2.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate2 = firstRectangles[1];
                                        for (int i = 0; i < 4; i++) {
                                            secondStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet2.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = secondStackRectangles[CardSet2.getCardCount() - 2];
                                }else{
                                    jeuUpdate = firstRectangles[1];
                                    for (int i = 0; i < 4; i++) {
                                        secondStackRectangles[i].setFill(null);
                                    }
                                    CardSet2.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = secondStackRectangles[CardSet2.getCardCount() - 2];
                                }
                                break;
                            case 2:
                                CardSet3.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet3.getCardCount() > 1){
                                    jeuUpdate = thirdStackRectangles[CardSet3.getCardCount() - 2];
                                    if(CardSet3.getCardCount() == 5){
                                        CardSet3.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate2 = firstRectangles[2];
                                        for (int i = 0; i < 4; i++) {
                                            thirdStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet3.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = thirdStackRectangles[CardSet3.getCardCount() - 2];
                                }else{
                                    jeuUpdate = firstRectangles[2];
                                    for (int i = 0; i < 4; i++) {
                                        thirdStackRectangles[i].setFill(null);
                                    }
                                    CardSet3.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = thirdStackRectangles[CardSet3.getCardCount() - 2];
                                }
                                break;
                            case 3:
                                CardSet4.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet4.getCardCount() > 1){
                                    jeuUpdate = fourthStackRectangles[CardSet4.getCardCount() - 2];
                                    if(CardSet4.getCardCount() == 5){
                                        CardSet4.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate2 = firstRectangles[3];
                                        for (int i = 0; i < 4; i++) {
                                            fourthStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet4.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = fourthStackRectangles[CardSet4.getCardCount() - 2];
                                }else{
                                    jeuUpdate = firstRectangles[3];
                                    for (int i = 0; i < 4; i++) {
                                        fourthStackRectangles[i].setFill(null);
                                    }
                                    CardSet4.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate2 = fourthStackRectangles[CardSet4.getCardCount() - 2];
                                }
                                break;
                        }
                        Image image = CardImages.getFrontImage(player1.chosenCard);
                        Image image2 = CardImages.getFrontImage(player2.chosenCard);
                        ImagePattern imagePattern = new ImagePattern(image);
                        ImagePattern imagePattern2 = new ImagePattern(image2);
                        jeuUpdate.setFill(imagePattern);
                        jeuUpdate2.setFill(imagePattern2);
                    }else{
                        switch (indexP1){
                            case 0:
                                CardSet1.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet1.getCardCount() > 1){
                                    jeuUpdate2 = firstStackRectangles[CardSet1.getCardCount() - 2];
                                    if(CardSet1.getCardCount() == 5){
                                        CardSet1.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate = firstRectangles[0];
                                        for (int i = 0; i < 4; i++) {
                                            firstStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet1.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = firstStackRectangles[CardSet1.getCardCount() - 2];
                                }else{
                                    jeuUpdate2 = firstRectangles[0];
                                    for (int i = 0; i < 4; i++) {
                                        firstStackRectangles[i].setFill(null);
                                    }
                                    CardSet1.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = firstStackRectangles[CardSet1.getCardCount() - 2];
                                }
                                break;
                            case 1:
                                CardSet2.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet2.getCardCount() > 1){
                                    jeuUpdate2 = secondStackRectangles[CardSet2.getCardCount() - 2];
                                    if(CardSet2.getCardCount() == 5){
                                        CardSet2.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate = firstRectangles[1];
                                        for (int i = 0; i < 4; i++) {
                                            secondStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet2.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = secondStackRectangles[CardSet2.getCardCount() - 2];
                                }else{
                                    jeuUpdate2 = firstRectangles[1];
                                    for (int i = 0; i < 4; i++) {
                                        secondStackRectangles[i].setFill(null);
                                    }
                                    CardSet2.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = secondStackRectangles[CardSet2.getCardCount() - 2];
                                }
                                break;
                            case 2:
                                CardSet3.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet3.getCardCount() > 1){
                                    jeuUpdate2 = thirdStackRectangles[CardSet3.getCardCount() - 2];
                                    if(CardSet3.getCardCount() == 5){
                                        CardSet3.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate = firstRectangles[2];
                                        for (int i = 0; i < 4; i++) {
                                            thirdStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet3.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = thirdStackRectangles[CardSet3.getCardCount() - 2];
                                }else{
                                    jeuUpdate2 = firstRectangles[2];
                                    for (int i = 0; i < 4; i++) {
                                        thirdStackRectangles[i].setFill(null);
                                    }
                                    CardSet3.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = thirdStackRectangles[CardSet3.getCardCount() - 2];
                                }
                                break;
                            case 3:
                                CardSet4.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                                if(CardSet4.getCardCount() > 1){
                                    jeuUpdate2 = fourthStackRectangles[CardSet4.getCardCount() - 2];
                                    if(CardSet4.getCardCount() == 5){
                                        CardSet4.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                        jeuUpdate = firstRectangles[3];
                                        for (int i = 0; i < 4; i++) {
                                            fourthStackRectangles[i].setFill(null);
                                        }
                                    }
                                    CardSet4.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = fourthStackRectangles[CardSet4.getCardCount() - 2];
                                }else{
                                    jeuUpdate2 = firstRectangles[3];
                                    for (int i = 0; i < 4; i++) {
                                        fourthStackRectangles[i].setFill(null);
                                    }
                                    CardSet4.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                                    jeuUpdate = fourthStackRectangles[CardSet4.getCardCount() - 2];
                                }
                                break;
                        }
                        Image image = CardImages.getFrontImage(player1.chosenCard);
                        Image image2 = CardImages.getFrontImage(player2.chosenCard);
                        ImagePattern imagePattern = new ImagePattern(image);
                        ImagePattern imagePattern2 = new ImagePattern(image2);
                        jeuUpdate.setFill(imagePattern);
                        jeuUpdate2.setFill(imagePattern2);
                    }
                }else {
                    switch (indexP1) {
                        case 0:
                            CardSet1.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet1.getCardCount() > 1){
                                jeuUpdate = firstStackRectangles[CardSet1.getCardCount() - 2];
                            }else{
                                jeuUpdate = firstRectangles[0];
                                for (int i = 0; i < 4; i++) {
                                    firstStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                        case 1:
                            CardSet2.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet2.getCardCount() > 1){
                                jeuUpdate = secondStackRectangles[CardSet2.getCardCount() - 2];
                            }else{
                                jeuUpdate = firstRectangles[1];
                                for (int i = 0; i < 4; i++) {
                                    secondStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                        case 2:
                            CardSet3.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet3.getCardCount() > 1){
                                jeuUpdate = thirdStackRectangles[CardSet3.getCardCount() - 2];
                            }else{
                                jeuUpdate = firstRectangles[2];
                                for (int i = 0; i < 4; i++) {
                                    thirdStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                        case 3:
                            CardSet4.addMayTakeIfBelowOr6th(player1.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet4.getCardCount() > 1){
                                jeuUpdate = fourthStackRectangles[CardSet4.getCardCount() - 2];
                            }else{
                                jeuUpdate = firstRectangles[3];
                                for (int i = 0; i < 4; i++) {
                                    fourthStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                    }
                    switch (indexP2) {
                        case 0:
                            CardSet1.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet1.getCardCount() > 1){
                                jeuUpdate2 = firstStackRectangles[CardSet1.getCardCount() - 2];
                            }else{
                                jeuUpdate2 = firstRectangles[0];
                                for (int i = 0; i < 4; i++) {
                                    firstStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                        case 1:
                            CardSet2.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet2.getCardCount() > 1){
                                jeuUpdate2 = secondStackRectangles[CardSet2.getCardCount() - 2];
                            }else{
                                jeuUpdate2 = firstRectangles[1];
                                for (int i = 0; i < 4 ; i++) {
                                    secondStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                        case 2:
                            CardSet3.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet3.getCardCount() > 1){
                                jeuUpdate2 = thirdStackRectangles[CardSet3.getCardCount() - 2];
                            }else{
                                jeuUpdate2 = firstRectangles[2];
                                for (int i = 0; i < 4; i++) {
                                    thirdStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                        case 3:
                            CardSet4.addMayTakeIfBelowOr6th(player2.getChosenCard(), currentPlayer, player1, player2);
                            if(CardSet4.getCardCount() > 1){
                                jeuUpdate2 = fourthStackRectangles[CardSet4.getCardCount() - 2];
                            }else{
                                jeuUpdate2 = firstRectangles[3];
                                for (int i = 0; i < 4; i++) {
                                    fourthStackRectangles[i].setFill(null);
                                }
                            }
                            break;
                    }
                    Image image = CardImages.getFrontImage(player1.chosenCard);
                    ImagePattern imagePattern = new ImagePattern(image);
                    jeuUpdate.setFill(imagePattern);

                    Image image2 = CardImages.getFrontImage(player2.chosenCard);
                    ImagePattern imagePattern2 = new ImagePattern(image2);
                    jeuUpdate2.setFill(imagePattern2);
                }
                System.out.println("Minimum differenceP1: " + minDifferenceP1);
                System.out.println("Minimum differenceP2: " + minDifferenceP2);
                currentPlayer.setChosenCard(null);
                Topvalues.clear();
                Topvalues.add(CardSet1.getTopValue());
                Topvalues.add(CardSet2.getTopValue());
                Topvalues.add(CardSet3.getTopValue());
                Topvalues.add(CardSet4.getTopValue());
            }
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
