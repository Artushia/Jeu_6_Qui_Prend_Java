package com.example.jeu_6_qui_prend_java.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Player {

    public int playerNumber;
    public CardSet playerCardSet;
    public int playerScore;
    public boolean Playerturn;
    public Card chosenCard;

    public Player(int playerNumber, CardSet cardSet, int playerScore,boolean Playerturn, Card chosenCard) {
        this.playerNumber = playerNumber;
        this.playerCardSet = cardSet;
        this.playerScore = playerScore;
        this.Playerturn = Playerturn;
        this.chosenCard = chosenCard;
    }

}
