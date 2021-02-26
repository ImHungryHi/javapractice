package cardgame;

public class Card {
    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return (Rank.NAMES[rank] + " of " + Suit.NAMES[suit]);
    }
}
