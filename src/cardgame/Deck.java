package cardgame;

import java.util.Random;

public class Deck {
    private Card[] cards;
    private int decksize;

    public Deck() {
        decksize = 52;
        this.cards = new Card[decksize];
        int idx = 0;

        for (int x = Suit.MIN; x <= Suit.MAX; x++) {
            for (int y = Rank.MIN; y <= Rank.MAX; y++) {
                // We multiply the SUIT index with the RANK maximum to get to the following SUIT's first index
                //int idx = (x * Rank.MAX) + (y - 1);

                // Let's opt for the simpler index variable, less calculation power needed
                this.cards[idx++] = new Card(y, x);
            }
        }
    }

    public Deck(int decksize) {
        this.decksize = decksize;
        this.cards = new Card[decksize];
        int idx = 0;

        for (int x = Suit.MIN; x <= Suit.MAX; x++) {
            for (int y = Rank.MIN; y <= Rank.MAX; y++) {
                this.cards[idx++] = new Card(y, x);
                if (idx >= decksize) {
                    return;
                }
            }
        }
    }

    public void showDeck() {
        //for (Card c : this.cards) {
        for (int x = 0; x < this.cards.length; x++) {
            System.out.println("[" + x + "] = " + this.cards[x]);
        }
    }

    private static int randomInt(int low, int high) {
        Random r = new Random();
        // Set a low bounds by returning a random + low and
        //   deduct low from high to set a high to get the random between low and high
        return r.nextInt(high - low) + low;
    }

    private void swapCards(int i, int j) {
        if (i == j) {
            return;
        }

        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
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
    }

    public void selectionSort() {
        int lowest; // best practice, less declarations

        for (int x = 0; x < (cards.length - 1); x++) {
            lowest = indexLowest(x, (cards.length - 1));
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
        int totalSize = d1.cards.length + d2.cards.length;
        int n = 0;
        int m = 0;
        Deck d3 = new Deck(totalSize);
        Card first, second;

        for (int x = 0; x < totalSize; x++) {
            first = d1.cards[n];
            second = d2.cards[m];

            if (first.compareTo(second, true) <= 0) {
                d3.cards[x] = first;
                n++;
            }
            else {
                d3.cards[x] = second;
                m++;
            }
        }

        return d3;
    }

    private int indexLowest(int low, int high) {
        int lowest = low;

        for (int x = low; x <= high; x++) {
            if (cards[lowest].compareTo(cards[x], true) > 0) {
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
