package cardgame;

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
}
