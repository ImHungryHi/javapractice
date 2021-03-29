package chapter13.c;

import java.util.Arrays;
import java.util.Random;

public class Deck {
    private Card[] cards;
    private Random random = new Random();

    public Deck() {
        cards = new Card[52];
        int index = 0;

        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index++] = new Card(rank, suit);
            }
        }
    }

    public Deck(int n) {
        cards = new Card[n];
    }

    public Card[] getCards() {
        return cards;
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    private int randomInt(int low, int high) {
        return random.nextInt(high - low) + low;
    }

    private void swapCards(int i, int j) {
        if (i == j) {
            return;
        }

        Card[] cards = getCards();
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    public void shuffle() {
        for (int x = 0; x < cards.length; x++) {
            swapCards(x, randomInt(1, (cards.length - 1)));
        }
    }

    private int indexLowest(int low, int high) {
        int lowest = low;

        for (int x = low; x <= high; x++) {
            if (cards[lowest].compareTo(cards[x]) > 0) {
                lowest = x;
            }
        }

        return lowest;
    }

    public void selectionSort() {
        int cardsSize = cards.length - 1;
        int lowest; // best practice, less declarations

        for (int x = 0; x < cardsSize; x++) {
            lowest = indexLowest(x, cardsSize);
            swapCards(x, lowest);
        }
    }

    public Deck almostMergeSort() {
        int halfway = cards.length / 2;
        Deck d1 = subDeck(0, halfway);
        Deck d2 = subDeck(halfway + 1, cards.length - 1);
        d1.selectionSort();
        d2.selectionSort();

        return merge(d1, d2);
    }

    /*public Card[] mergeSort(Card[] arrFirst, Card[] arrSecond) {
        int totalSize = arrFirst.length + arrSecond.length;
        int n = 0;
        int m = 0;
        Card[] arrResult = new Card[totalSize];

        for (int x = 0; x < totalSize; x++) {
            if (arrFirst[n].compareTo(arrSecond[m]) <= 0) {
                arrResult[x] = arrFirst[n++];
            }
            else {
                arrResult[x] = arrSecond[m++];
            }
        }

        return arrResult;
    }*/

    public void mergeSort() {
        if (cards.length <= 1) {
            return;
        }

        int halfway = cards.length / 2;
        Deck d1 = subDeck(0, halfway - 1);
        Deck d2 = subDeck(halfway, cards.length - 1);
        d1.mergeSort();
        d2.mergeSort();
        this.cards = merge(d1, d2).cards;
    }

    public static Deck merge(Deck d1, Deck d2) {
        int n = 0;
        int m = 0;
        int totalSize = d1.cards.length + d2.cards.length;
        Deck d3 = new Deck(totalSize);

        for (int x = 0; x < totalSize; x++) {
            if (n >= d1.cards.length) {
                d3.cards[x] = d2.cards[m++];
            }
            else if (m >= d2.cards.length) {
                d3.cards[x] = d1.cards[n++];
            }
            else {
                if (d1.cards[n].compareTo(d2.cards[m]) <= 0) {
                    d3.cards[x] = d1.cards[n++];
                } else {
                    d3.cards[x] = d2.cards[m++];
                }
            }
        }

        return d3;
    }

    public Deck subDeck(int low, int high) {
        Deck sub = new Deck((high - low) + 1);

        for (int x = 0; x < sub.cards.length; x++) {
            sub.cards[x] = this.cards[low + x];
        }

        return sub;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Card card : cards) {
            if (first) {
                first = false;
            }
            else {
                result.append("\n");
            }

            result.append(card);
        }

        return result.toString();
    }
}
