package cardgame;

import java.util.ArrayList;

public class War {
    private Pile pile1;
    private Pile pile2;
    private Deck deck;

    public War() {
        deck = new Deck();
        deck.shuffle();
        pile1 = new Pile();
        pile2 = new Pile();
        pile1.addDeck(deck.subDeck(0, 25));
        pile2.addDeck(deck.subDeck(26, 51));
    }

    public void play() {
        Card first, second;
        Pile subPile;
        int difference = 0;

        while(!pile1.isEmpty() && !pile2.isEmpty()) {
            first = pile1.popCard();
            second = pile2.popCard();
            difference = first.getRank() - second.getRank();

            if (difference > 0) {
                pile1.addCard(first);
                pile1.addCard(second);
            }
            else if (difference < 0) {
                pile2.addCard(first);
                pile2.addCard(second);
            }
            else {
                ArrayList<Card> tablePile = new ArrayList<>();
                tablePile.add(first);
                tablePile.add(second);

                // Nothing happens, players draw 4 cards each - if they can - with the final card being
                //  the deciding card to fight
                while (true) {
                    for (int x = 0; x < 4; x++) {
                        if (!pile1.isEmpty()) {
                            first = pile1.popCard();
                            tablePile.add(first);
                        }

                        if (!pile2.isEmpty()) {
                            second = pile2.popCard();
                            tablePile.add(second);
                        }
                    }

                    difference = first.getRank() - second.getRank();

                    if (difference > 0) {
                        for (Card tableCard : tablePile) {
                            pile1.addCard(tableCard);
                        }

                        break;
                    }
                    else if (difference < 0) {
                        for (Card tableCard : tablePile) {
                            pile2.addCard(tableCard);
                        }

                        break;
                    }
                }
            }
        }

        if (pile1.isEmpty()) {
            System.out.println("Player 2 wins!");
        }
        else {
            System.out.println("Player 1 wins!");
        }
    }
}
