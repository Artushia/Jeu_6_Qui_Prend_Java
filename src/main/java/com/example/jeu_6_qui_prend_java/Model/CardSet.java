package com.example.jeu_6_qui_prend_java.Model;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class CardSet {

    private final TreeSet<Card> cards = new TreeSet<>();

    //---------------------------------------------------------------------------------------------

    public CardSet(Collection<Card> ls) {
        cards.addAll(ls);
    }

    //---------------------------------------------------------------------------------------------

    public Collection<Card> remains() {
        return Collections.unmodifiableSet(cards);
    }

    public void take(Card c) {
        boolean remove = cards.remove(c);
        if (!remove) throw new IllegalArgumentException();
    }

    public Card getCard(int i) {
        if (i < 0 || i >= cards.size()) {
            throw new IndexOutOfBoundsException("Invalid card index: " + i);
        }

        Iterator<Card> iterator = cards.iterator();
        int currentIndex = 0;
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (currentIndex == i) {
                return card;
            }
            currentIndex++;
        }

        // This point should not be reached if the index is valid
        throw new IllegalStateException("Unable to find card at index: " + i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CardSet: [");
        for (Card card : cards) {
            sb.append(card.toString()).append(", ");
        }
        if (!cards.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // 마지막 ", " 제거
        }
        sb.append("]");
        return sb.toString();
    }

}