package cardgame;

import java.util.Random;

public class Deck {
    private Card[] cards;
    private final int DECKSIZE = 52;

    public Deck() {
        this.cards = new Card[DECKSIZE];
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

    public void showDeck() {
        for (Card c : this.cards) {
            System.out.println(c);
        }
    }

    private static int randomInt(int low, int high) {
        Random r = new Random();
        // Set a low bounds by returning a random + low and
        //   deduct low from high to set a high to get the random between low and high
        return r.nextInt(high - low) + low;
    }

    private void swapCards(int i, int j) {
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
