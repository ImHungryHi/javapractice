package cardgame;

import java.util.Arrays;
import java.util.Objects;

public class Card {
    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;

        if (this.rank < Rank.MIN || this.rank > Rank.MAX) throw new IndexOutOfBoundsException("Could not find the input rank " + rank);
        if (this.suit < Suit.MIN || this.suit > Suit.MAX) throw new IndexOutOfBoundsException("Could not find the input suit " + suit);
    }

    public Card(int rank, String suit) {
        this.rank = rank;
        //this.suit = Arrays.asList(Suit.NAMES).lastIndexOf(suit);
        this.suit = indexOf(suit, Suit.NAMES);

        if (this.rank < Rank.MIN || this.rank > Rank.MAX) throw new IndexOutOfBoundsException("Could not find the input rank " + rank);
        if (this.suit < Suit.MIN || this.suit > Suit.MAX) throw new IndexOutOfBoundsException("Could not find the input suit " + suit);
    }

    public Card(String rank, int suit) {
        if (rank.equals("1")) {
            this.rank = 1;
        }
        else {
            //this.rank = Arrays.asList(Rank.NAMES).lastIndexOf(rank);
            this.rank = indexOf(rank, Rank.NAMES);
        }

        this.suit = suit;

        if (this.rank < Rank.MIN || this.rank > Rank.MAX) throw new IndexOutOfBoundsException("Could not find the input rank " + rank);
        if (this.suit < Suit.MIN || this.suit > Suit.MAX) throw new IndexOutOfBoundsException("Could not find the input suit " + suit);
    }

    public Card(String rank, String suit) {
        if (rank.equals("1")) {
            this.rank = 1;
        }
        else {
            //this.rank = Arrays.asList(Rank.NAMES).lastIndexOf(rank);
            this.rank = indexOf(rank, Rank.NAMES);
        }

        //this.suit = Arrays.asList(Suit.NAMES).lastIndexOf(suit);
        this.suit = indexOf(suit, Suit.NAMES);

        if (this.rank < Rank.MIN || this.rank > Rank.MAX) throw new IndexOutOfBoundsException("Could not find the input rank " + rank);
        if (this.suit < Suit.MIN || this.suit > Suit.MAX) throw new IndexOutOfBoundsException("Could not find the input suit " + suit);
    }

    // Metadata annotations (gives info about the method below)
    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check reference
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    /**
     * Resulting in:
     * -3 Invalid input
     * -2 Different suit, lower rank
     * -1 Same suit, lower rank
     * 0 Same suit & rank
     * 1 Same suit, higher rank
     * 2 Different suit, higher rank
     * 3 Different suit, same rank
     * @param otherCard Card to compare to
     * @return int
     */
    public int compareTo(Card otherCard) {
        if (this.suit <= Suit.MAX && this.suit >= Suit.MIN && this.rank <= Rank.MAX && this.rank >= Rank.MIN &&
                otherCard.suit <= Suit.MAX && otherCard.suit >= Suit.MIN && otherCard.rank <= Rank.MAX && otherCard.rank >= Rank.MIN) {
            if (this.suit == otherCard.suit) {
                if (this.rank > otherCard.rank) return 1;
                else if (this.rank < otherCard.rank) return -1;
                else return 0;
            }
            else {
                if (this.rank > otherCard.rank) return 2;
                else if (this.rank < otherCard.rank) return -2;
                else return 3;
            }
        }

        return -3;
    }

    private int indexOf(String needle, String[] haystack) {
        for (int x = 0; x < haystack.length; x++) {
            boolean noNulls = needle != null && haystack[x] != null;

            // Gives a NullPointerException for null values
            //if (haystack[x].equals(needle)) System.out.println("I don't like null comparisons");

            // Gives NO NullPointerException for null values, unless [needle] == null
            //if (needle.equals(haystack[x])) {

            // For safe code's sake, we'll just include a null check
            if (noNulls && needle.equals(haystack[x])) {
                return x;
            }
        }

        return -1;
    }
}
