package com.example.jeu_6_qui_prend_java.Model;


public class Card implements Comparable<Card> {

    public final int value;
    public final int penalty;

    Card(int value, int penalty) {
        this.value = value;
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Card value : " + value;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.value, o.value);
    }
}
