package cardgame;

import java.util.Arrays;

public class Card {
    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = Arrays.asList(Suit.NAMES).lastIndexOf(suit);
    }

    public Card(String rank, int suit) {
        if (rank.equals("1")) {
            this.rank = 1;
        }
        else {
            this.rank = Arrays.asList(Rank.NAMES).lastIndexOf(rank);
        }

        this.suit = suit;
    }

    public Card(String rank, String suit) {
        if (rank.equals("1")) {
            this.rank = 1;
        }
        else {
            this.rank = Arrays.asList(Rank.NAMES).lastIndexOf(rank);
        }

        this.suit = Arrays.asList(Suit.NAMES).lastIndexOf(suit);
    }

    public String toString() {
        if (suit > Suit.MAX) {
            throw new IndexOutOfBoundsException("The current suit does not exist (index out of bounds suit " + suit + " < max " + Suit.MAX + ")");
        }
        else if (suit < Suit.MIN) {
            throw new IndexOutOfBoundsException("The current suit does not exist (index out of bounds suit " + suit + " > min " + Suit.MIN + ")");
        }

        if (rank > Rank.MAX) {
            throw new IndexOutOfBoundsException("The current rank does not exist (index out of bounds rank " + rank + " < max " + Rank.MAX + ")");
        }
        else if (rank < Rank.MIN) {
            throw new IndexOutOfBoundsException("The current rank does not exist (index out of bounds rank " + rank + " > min " + Rank.MIN + ")");
        }

        return (Rank.NAMES[rank] + " of " + Suit.NAMES[suit]);
    }

    private int indexOf(String needle, String[] haystack) {
        for (int x = 0; x < haystack.length; x++) {
            if (needle.equals(haystack[x])) {
                return x;
            }
        }

        return -1;
    }
}
