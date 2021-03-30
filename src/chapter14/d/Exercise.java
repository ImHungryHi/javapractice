package chapter14.d;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Changes made:
 * ======================
 * cardMatches in Player => matches in Card
 *    Changes references in drawForMatch + searchForMatch in Player
 * Card => EightsCard
 *    Changes references in takeTurn + drawCard in Eights
 *    Changes references in constructor in Deck (fill with EightsCard instead of Card)
 * Hand => EightsHand
 *    Changes references in searchForMatch + play in Player
 *    Changes references in attributes + constructor in Eights
 */

public class Exercise {
    public static void main(String[] args) {
        Player one = new Player("Chris");
        Player two = new Player("Jean");
        Player three = new Player("Lukske");
        EightsHand drawPile = new EightsHand("Draw Pile");
        EightsHand discardPile = new EightsHand("Discard Pile");
        ArrayList<Player> players = new ArrayList<>() {{
            add(one);
            add(two);
            add(three);
        }};

        for (int x = 0; x < 100; x++) {
            Deck deck = new Deck("Deck");
            deck.shuffle();
            deck.deal(discardPile, 1);
            deck.dealAll(drawPile);

            for (Player p : players) {
                drawPile.deal(p.getHand(), 5);
            }

            // Play a game of eights
            Scanner in = new Scanner(System.in);
            Eights eights = new Eights(players, drawPile, discardPile, in);
            eights.playGame();

            Hand destroy = new Hand("Destroy");

            for (Player p : players) {
                if (!p.getHand().isEmpty()) {
                    p.getHand().dealAll(destroy);
                }

                p.resetScore();
            }

            if (!drawPile.isEmpty()) {
                drawPile.dealAll(destroy);
            }

            if (!discardPile.isEmpty()) {
                discardPile.dealAll(destroy);
            }
        }

        System.out.println("==========================================");

        for (Player p : players) {
            System.out.println(p.getName() + " won " + p.getWins() + " times");
        }
    }
}
