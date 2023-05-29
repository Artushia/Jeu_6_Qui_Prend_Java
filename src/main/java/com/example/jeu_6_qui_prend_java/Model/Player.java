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
@AllArgsConstructor
public class Player {
    public int playerNumber;
    public List<CardSet> playerCardSet = new ArrayList<CardSet>();
    public int playerScore;

    public boolean Playerturn;

    public Player(int playerNumber, CardSet cardSet, int playerScore,boolean Playerturn) {
        this.playerNumber = playerNumber;
        this.playerCardSet.add(cardSet);
        this.playerScore = playerScore;
        this.Playerturn = Playerturn;
    }
}
