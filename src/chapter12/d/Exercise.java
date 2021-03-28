package chapter12.d;

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

    public static int[] suitHist(Card[] cards) {
        int[] hist = new int[4];

        for (Card card : cards) {
            hist[card.getSuit()]++;
        }

        return hist;
    }

    public static boolean hasFlush(Card[] cards) {
        int[] hist = suitHist(cards);

        for (int i : hist) {
            if (i > 4) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasRoyal(Card[] cards) {
        int[] royalHist = new int[4];

        for (Card card : cards) {
            int rank = card.getRank();

            if (rank >= 10 || rank == 1) {
                int suit = card.getSuit();
                royalHist[suit]++;

                if (royalHist[suit] > 4) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
