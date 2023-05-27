package com.example.jeu_6_qui_prend_java.Controller;

import com.example.jeu_6_qui_prend_java.Model.Card;
import com.example.jeu_6_qui_prend_java.Model.Cards;
import javafx.scene.image.Image;

import java.net.URL;

public class CardImages {

    //private static final Image backsideImage = createBacksizeImage();

    //private static final Image[] cardImages = createCardImages();

    //---------------------------------------------------------------------------------------------

    /*public static Image getBacksideImage() {
        return backsideImage;
    }*/

   /* public static Image getFrontCardImage(Card card) {
        return (card != null)? cardImages[card.value] : backsideImage;
    }*/

   /* private static Image createBacksizeImage() {
        URL imgUrl = CardImages.class.getResource("backside.png");
        return new Image(imgUrl.toExternalForm());
    }*/

    /*private static Image[] createCardImages() {
        Image[] res = new Image[1+ Cards.MAX_CARD_VALUE];
        res[0] = null;
        for(int i = 1; i <= Cards.MAX_CARD_VALUE; i++) {
            URL imgUrl = CardImages.class.getResource(i + ".png");
            res[i] = new Image(imgUrl.toExternalForm());
        }
        return res;
    }*/

    public static Image getFrontImage(Card card){
        URL imgUrl = CardImages.class.getResource("/card/" + card.value + ".png");
        assert imgUrl != null;
        return new Image(imgUrl.toExternalForm());
    }

}
