package cardgame;

public class Deck {
    private Card[] cards;
    private final int DECKSIZE = 52;

    public Deck() {
        this.cards = new Card[DECKSIZE];

        for (int x = 0; x <= Suit.MAX; x++) {
            for (int y = 0; y < Rank.MAX; y++) {
                // We multiply the SUIT index with the RANK maximum to get to the following SUIT's first index
                int idx = (x * Rank.MAX) + y;
                this.cards[idx] = new Card((y + 1), x);
            }
        }
    }
}
