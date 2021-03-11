package cardgame;

import java.util.ArrayList;

public class SmartPile extends ArrayList<Card> {
    // add already exists, and so does isEmpty.
    public Card pop() {
        return remove(size() - 1);
    }

    public void addDeck(Deck deck) {
        addAll(deck.getCards());
        /*for (Card c : deck.getCards()) {
            add(c);
        }*/
    }
}
