package com.example.jeu_6_qui_prend_java.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    public int playerNumber;
    public List<Card> playerCardSet;
}
