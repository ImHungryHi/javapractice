package cardgame;

import java.util.ArrayList;
import java.util.Random;

public class Deck extends CardCollection {
    private int decksize;

    public Deck() {
        super("deck");
        decksize = 52;

        for (int x = Suit.MIN; x <= Suit.MAX; x++) {
            for (int y = Rank.MIN; y <= Rank.MAX; y++) {
                // We multiply the SUIT index with the RANK maximum to get to the following SUIT's first index
                //int idx = (x * Rank.MAX) + (y - 1);

                // Let's opt for the simpler index variable, less calculation power needed
                addCard(new Card(y, x));
            }
        }
    }

    public Deck(String label) {
        super(label);
        decksize = 52;

        for (int x = Suit.MIN; x <= Suit.MAX; x++) {
            for (int y = Rank.MIN; y <= Rank.MAX; y++) {
                // We multiply the SUIT index with the RANK maximum to get to the following SUIT's first index
                //int idx = (x * Rank.MAX) + (y - 1);

                // Let's opt for the simpler index variable, less calculation power needed
                addCard(new Card(y, x));
            }
        }
    }

    public Deck(int decksize) {
        super("deck");
        this.decksize = decksize;
        int idx = 0;

        for (int x = Suit.MIN; x <= Suit.MAX; x++) {
            for (int y = Rank.MIN; y <= Rank.MAX; y++) {
                addCard(new Card(y, x));
                idx++;

                if (idx >= decksize) {
                    return;
                }
            }
        }
    }

    public Deck(int decksize, String label) {
        super(label);
        this.decksize = decksize;
        int idx = 0;

        for (int x = Suit.MIN; x <= Suit.MAX; x++) {
            for (int y = Rank.MIN; y <= Rank.MAX; y++) {
                addCard(new Card(y, x));
                idx++;

                if (idx >= decksize) {
                    return;
                }
            }
        }
    }

    public void showDeck() {
        //for (Card c : cards) {
        for (int x = 0; x < size(); x++) {
            System.out.println("[" + x + "] = " + getCard(x));
        }
    }

    private static int randomInt(int low, int high) {
        Random r = new Random();
        // Set a low bounds by returning a random + low and
        //   deduct low from high to set a high to get the random between low and high
        return r.nextInt(high - low) + low;
    }

    /*private void swapCards(int i, int j) {
        if (i == j) {
            return;
        }

        ArrayList<Card> cards = getCards();

        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    public void shuffle() {
        for (int x = 0; x < cards.length; x++) {
            swapCards(x, randomInt(1, (cards.length - 1)));
        }
    }

    public void shuffle(int seconds) {
        TimingUtil timing = new TimingUtil(seconds);
        timing.start();

        while (!timing.isFinished()) {
            int random1 = randomInt(1, cards.length - 1);
            int random2 = -1;

            while (true) {
                if (random2 < 0 || random2 == random1) {
                    random2 = randomInt(1, cards.length - 1);
                }
                else {
                    break;
                }
            }

            swapCards(random1, random2);
        }
    }*/

    public void selectionSort() {
        int cardsSize = size() - 1;
        int lowest; // best practice, less declarations

        for (int x = 0; x < cardsSize; x++) {
            lowest = indexLowest(x, cardsSize);
            swapCards(x, lowest);
        }
    }

    public void mergeSort(Card[] arrFirst, Card[] arrSecond) {
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
    }

    public static Deck merge(Deck d1, Deck d2) {
        int n = 0;
        int m = 0;
        int totalSize = d1.size() + d2.size();
        Deck d3 = new Deck(totalSize);

        for (int x = 0; x < totalSize; x++) {
            if (n >= d1.size()) {
                d3.setCard(x, d2.getCard(m++));
            }
            else if (m >= d2.size()) {
                d3.setCard(x, d1.getCard(n++));
            }
            else {
                if (d1.getCard(n).compareTo(d2.getCard(m), true) <= 0) {
                    d3.setCard(x, d1.getCard(n++));
                } else {
                    d3.setCard(x, d2.getCard(m++));
                }
            }
        }

        return d3;
    }

    public Deck mergeRecursive() {
        int length = size();

        if (length <= 1) {
            return this;
        }
        else {
            int mid = length / 2;
            Deck first = subDeck(0, mid - 1).mergeRecursive();
            Deck second = subDeck(mid, length - 1).mergeRecursive();
            return merge(first, second);
        }
    }

    public Deck subDeck(int low, int high) {
        Deck sub = new Deck((high - low) + 1);

        for (int x = 0; x < sub.size(); x++) {
            sub.setCard(x, getCard(low + x));
        }

        return sub;
    }

    private int indexLowest(int low, int high) {
        int lowest = low;

        for (int x = low; x <= high; x++) {
            if (getCard(lowest).compareTo(getCard(x), true) > 0) {
                lowest = x;
            }
        }

        return lowest;
    }

    private static class TimingUtil extends Thread {
        private long time = 0;
        private boolean finished = false;

        public TimingUtil(int time) {
            this.time = time * 1000;
        }

        public void run() {
            if (time == 0) {
                time = 5000;
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }

            finished = true;
        }

        public boolean isFinished() {
            return finished;
        }
    }
}
