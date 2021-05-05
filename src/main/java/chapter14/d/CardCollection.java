package chapter14.d;

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
        int i = cards.size() - 1;
        return cards.remove(i);
    }

    public Card popCard(int i) {
        return cards.remove(i);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public Card lastCard() {
        int i = cards.size() - 1;

        if (i < 0) {
            return null;
        }

        return cards.get(i);
    }

    public void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    public void shuffle() {
        Random random = new Random();
        for (int x = cards.size() - 1; x > 0; x--) {
            int y = random.nextInt(x + 1);
            swapCards(x, y);
        }
    }

    public String getLabel() {
        return label;
    }

    public void deal(CardCollection that, int n) {
        for (int x = 0; x < n; x++) {
            Card card = popCard();
            that.addCard(card);
        }
    }

    public void dealAll(CardCollection that) {
        int n = cards.size();
        deal(that, n);
    }
}
