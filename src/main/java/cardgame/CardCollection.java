package cardgame;

import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
    private String label;
    private ArrayList<Card> cards;

    public CardCollection(String label) {
        this.label = label;
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card popCard() {
        return popCard(cards.size() - 1);
    }

    public Card popCard(int i) {
        return cards.remove(i);
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void setCard(int i, Card c) {
        cards.set(i, c);
    }

    public Card lastCard() {
        return getCard(cards.size() - 1);
    }

    public void swapCards(int n, int m) {
        if (n == m) {
            return;
        }

        Card temp = cards.get(n);
        cards.set(n, cards.get(m));
        cards.set(m, temp);
    }

    public void shuffle() {
        Random r = new Random();

        for (int i = cards.size() - 1; i >= 0; i--) {
            swapCards(i, r.nextInt(i + 1));
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
