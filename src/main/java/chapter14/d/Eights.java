package chapter14.d;

import java.util.ArrayList;
import java.util.Scanner;

public class Eights {
    private ArrayList<Player> players;
    private EightsHand drawPile;
    private EightsHand discardPile;
    private Scanner in;

public Eights(ArrayList<Player> players, EightsHand drawPile, EightsHand discardPile, Scanner in) {
        this.players = players;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.in = in;
    }

    public boolean isDone() {
        boolean done = false;

        for (Player p : players) {
            if (p.getHand().isEmpty()) {
                done = true;
            }
        }

        return done;
    }

    public void reshuffle() {
        Card prev = discardPile.popCard();
        discardPile.dealAll(drawPile);
        discardPile.addCard(prev);
        drawPile.shuffle();
    }

    public EightsCard drawCard() {
        if (drawPile.isEmpty()) {
            reshuffle();
        }

        return drawPile.popCard();
    }

    public Player nextPlayer(Player current) {
        boolean pickNext = false;

        for (Player p : players) {
            if (pickNext) {
                return p;
            }

            if (current == p) {
                pickNext = true;
            }
        }

        // We're only getting here when "current" was the last player in the list
        return players.get(0);
    }

    public void displayState() {
        for (Player p : players) {
            p.display();
        }

        discardPile.display();
        System.out.println("Draw pile:");
        System.out.println(drawPile.size() + " cards");
        //in.nextLine();
    }

    public void takeTurn(Player player) {
        EightsCard prev = discardPile.lastCard();
        EightsCard next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    public void playGame() {
        Player player = players.get(0);

        while (!isDone()) {
            displayState();
            takeTurn(player);
            player = nextPlayer(player);
        }

        for (Player p : players) {
            p.displayScore();
        }
    }
}
