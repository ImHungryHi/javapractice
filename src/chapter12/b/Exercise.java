package chapter12.b;

public class Exercise {
    public static void main(String[] args) {
        Card[] cards = makeDeck();
    }

    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;

        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 1; rank < 14; rank++) {
                cards[index++] = new Card(rank, suit);
            }
        }

        return cards;
    }

    public static void printDeck(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
