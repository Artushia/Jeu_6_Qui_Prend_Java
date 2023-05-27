package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.Cards;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Random;


public class Le6QuiPrendApplication {

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


    public void displayInitCards() {
        vuejeu1.setImage(CardImages.getFrontImage(Cards.initialiseGameBoard(new Random()).get(0)));
        vuejeu1.setPreserveRatio(true);
        vuejeu1.setFitHeight(115);
        vuejeu7.setImage(CardImages.getFrontImage(Cards.initialiseGameBoard(new Random()).get(1)));
        vuejeu13.setImage(CardImages.getFrontImage(Cards.initialiseGameBoard(new Random()).get(2)));
        vuejeu19.setImage(CardImages.getFrontImage(Cards.initialiseGameBoard(new Random()).get(3)));
    }




}

