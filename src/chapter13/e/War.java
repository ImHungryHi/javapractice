package chapter13.e;

public class War {
    public static void main(String[] args) {
        // create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        // divide the deck into piles
        Pile p1 = new Pile();
        p1.addDeck(deck.subDeck(0, 25));
        Pile p2 = new Pile();
        p2.addDeck(deck.subDeck(26, 51));

        // while both piles are not empty
        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();

            // compare the cards
            int diff = c1.getRank() - c2.getRank();
            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
            } else {
                // it's a tie...draw four more cards
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
                        else {
                            System.out.println("Player 1 has less than 4 cards left\nPlayer 1 wins!");
                            return;
                        }

                        if (!p2.isEmpty()) {
                            c2 = p2.popCard();
                            System.out.println("Player 2 adds " + c2 + " to the pile");
                            tablePile.addCard(c2);
                        }
                        else {
                            System.out.println("Player 2 has less than 4 cards left\nPlayer 1 wins!");
                            return;
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

        // display the winner
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}
