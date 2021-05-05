package chapter13.c;

public class Exercise {
    public static void main(String[] args) {
        //playWar();
        Deck deck = new Deck();
        deck.shuffle();
        //System.out.println(deck);
        deck.mergeSort();
        System.out.println(deck);
    }

    public static void playWar() {
        Deck deck = new Deck();
        deck.shuffle();

        Pile p1 = new Pile();
        Pile p2 = new Pile();
        p1.addDeck(deck.subDeck(0, 25));
        p2.addDeck(deck.subDeck(26, 51));

        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();

            int diff = c1.getRank() - c2.getRank();

            if (diff > 0) {
                System.out.println(c1 + " > " + c2 + " player 1 wins the hand");
                p1.addCard(c1);
                p1.addCard(c2);
            }
            else if (diff < 0) {
                System.out.println(c1 + " < " + c2 + " player 2 wins the hand");
                p2.addCard(c1);
                p2.addCard(c2);
            }
            else {
                Pile tablePile = new Pile();
                tablePile.addCard(c1);
                tablePile.addCard(c2);

                // Nothing happens, players draw 4 cards each - if they can - with the final card being
                //  the deciding card to fight
                while (true) {
                    for (int x = 0; x < 4; x++) {
                        if (!p1.isEmpty()) {
                            c1 = p1.popCard();
                            System.out.println("Player 1 adds " + c1 + " to the pile");
                            tablePile.addCard(c1);
                        }

                        if (!p2.isEmpty()) {
                            c2 = p2.popCard();
                            System.out.println("Player 2 adds " + c2 + " to the pile");
                            tablePile.addCard(c2);
                        }
                    }

                    diff = c1.getRank() - c2.getRank();

                    if (diff > 0) {
                        System.out.println(c1 + " > " + c2 + " player 1 wins the hand");

                        while (!tablePile.isEmpty()) {
                            Card tableCard = tablePile.popCard();
                            p1.addCard(tableCard);
                        }

                        break;
                    }
                    else if (diff < 0) {
                        System.out.println(c1 + " < " + c2 + " player 2 wins the hand");

                        while (!tablePile.isEmpty()) {
                            Card tableCard = tablePile.popCard();
                            p2.addCard(tableCard);
                        }

                        break;
                    }
                }
            }
        }

        if (p2.isEmpty()) {
            System.out.println("=============================\n|\t\tPlayer 1 wins!\t\t|\n=============================");
        }
        else {
            System.out.println("=============================\n|\t\tPlayer 2 wins!\t\t|\n=============================");
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
