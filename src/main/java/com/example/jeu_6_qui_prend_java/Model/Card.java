package com.example.jeu_6_qui_prend_java.Model;

public class Card {

    public final int value;
    public final int heads;

    Card(int value, int heads) {
        this.value = value;
        this.heads = heads;
    }

    @Override
    public String toString() {
        return "Card value : " + value;
    }
}

