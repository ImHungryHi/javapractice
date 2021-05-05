package chapter14.a;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Deck deck = new Deck("Deck");
        deck.shuffle();

        Player one = new Player("Chris");
        Player two = new Player("Jean");
        deck.deal(one.getHand(), 5);
        deck.deal(two.getHand(), 5);

        Hand drawPile = new Hand("Draw Pile");
        Hand discardPile = new Hand("Discard Pile");
        deck.deal(discardPile, 1);
        deck.dealAll(drawPile);
        //System.out.printf("%s has %d cards.\n", drawPile.getLabel(), drawPile.size());

        // Play a game of eights
        Scanner in = new Scanner(System.in);
        Eights eights = new Eights(one, two, drawPile, discardPile, in);
        eights.playGame();
    }
}
