package cardgame;

import java.util.ArrayList;

public class Pile {
    private ArrayList<Card> cards;

    public Pile() {
        cards = new ArrayList<>();
    }

    public void  addCard(Card card) {
        cards.add(card);
    }

    public Card popCard() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        //return cards.size() == 0;
        return cards.isEmpty();
    }

    public void addDeck(Deck deck) {
        for (Card card : deck.getCards()) {
            cards.add(card);
        }
    }
}
