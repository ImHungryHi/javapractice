package chapter13.c;

import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> cards;

    public Pile() {
        this.cards = new ArrayList<Card>();
    }

    public Card popCard() {
        return cards.remove(0);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public void addDeck(Deck deck) {
        for (Card card : deck.getCards()) {
            cards.add(card);
        }
    }
}
