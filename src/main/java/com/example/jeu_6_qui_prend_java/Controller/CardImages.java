package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.Card;
import com.example.jeu_6_qui_prend_java.Model.Cards;
import javafx.scene.image.Image;

import java.net.URL;

public class CardImages {

    public static Image getFrontImage(Card card){
        URL imgUrl = CardImages.class.getResource("/card/" + card.value + ".png");
        assert imgUrl != null;
        return new Image(imgUrl.toExternalForm());
    }
}