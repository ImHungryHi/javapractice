package chapter14.b;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Player one = new Player("Chris");
        Player two = new Player("Jean");
        Hand drawPile = new Hand("Draw Pile");
        Hand discardPile = new Hand("Discard Pile");

        for (int x = 0; x < 100; x++) {
            Deck deck = new Deck("Deck");
            deck.shuffle();
            deck.deal(discardPile, 1);
            deck.dealAll(drawPile);
            drawPile.deal(one.getHand(), 5);
            drawPile.deal(two.getHand(), 5);

            // Play a game of eights
            Scanner in = new Scanner(System.in);
            Eights eights = new Eights(one, two, drawPile, discardPile, in);
            eights.playGame();

            Hand destroy = new Hand("Destroy");

            if (!one.getHand().isEmpty()) {
                one.getHand().dealAll(destroy);
            }

            if (!two.getHand().isEmpty()) {
                two.getHand().dealAll(destroy);
            }

            if (!drawPile.isEmpty()) {
                drawPile.dealAll(destroy);
            }

            if (!discardPile.isEmpty()) {
                discardPile.dealAll(destroy);
            }

            one.resetScore();
            two.resetScore();
        }

        System.out.println("==========================================");
        System.out.println(one.getName() + " won " + one.getWins() + " times");
        System.out.println(two.getName() + " won " + two.getWins() + " times");
    }
}
