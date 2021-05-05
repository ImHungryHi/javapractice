package chapter14.c;

public class Player {
    private String name;
    private Hand hand;
    private int scoreTally;
    private int wins;

    public Player(String name) {
        this.name = name;
        hand = new Hand(name);
        scoreTally = 0;
        wins = 0;
    }

    public Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);

        if (card == null) {
            card = drawForMatch(eights, prev);
        }

        return card;
    }

    public void score() {
        for (int x = 0; x < hand.size(); x++) {
            Card card = hand.getCard(x);
            scoreTally += card.getRank();
        }
    }

    public Card searchForMatch(Card prev) {
        if (prev == null) {
            return null;
        }

        Hand matches = new Hand("Matches");
        int highestRank = 0;
        int idxHighest = -1;

        for (int x = 0; x < hand.size(); x++) {
            Card card = hand.getCard(x);

            if (cardMatches(card, prev)) {
                Card matchingCard = hand.popCard(x);

                if (isEight(matchingCard)) {
                    return matchingCard;
                }

                matches.addCard(matchingCard);

                // Keep track of the highest rank to play first
                if (matchingCard.getRank() > highestRank) {
                    highestRank = matchingCard.getRank();
                    idxHighest = matches.size() - 1;
                }
            }
        }

        if (matches.size() > 0 && idxHighest >= 0) {
            return matches.popCard(idxHighest);
        }

        return null;
    }

    public Card drawForMatch(Eights eights, Card prev) {
        while(true) {
            Card card = eights.drawCard();
            System.out.println(name + " draws " + card);

            if (cardMatches(card, prev)) {
                return card;
            }

            hand.addCard(card);
        }
    }

    public static boolean cardMatches(Card card1, Card card2) {
        boolean sameSuit = card1.getSuit() == card2.getSuit();
        boolean sameRank = card1.getRank() == card2.getRank();
        return sameSuit || sameRank || isEight(card1);
    }

    private static boolean isEight(Card card) {
        return card.getRank() == 8;
    }

    public void display() {
        System.out.println("Player " + name + " hand:");
        hand.display();
    }

    public void displayScore() {
        if (scoreTally < 1) {
            score();
        }

        System.out.println("Player " + name + " score: " + scoreTally);
        
        if (scoreTally < 1) {
            System.out.println(name + " wins!");
            wins++;
        }
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void resetScore() {
        scoreTally = 0;
    }

    public int getScore() {
        return scoreTally;
    }
}
