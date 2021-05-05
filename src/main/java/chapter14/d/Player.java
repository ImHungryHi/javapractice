package chapter14.d;

public class Player {
    private String name;
    private EightsHand hand;
    private int scoreTally;
    private int wins;

    public Player(String name) {
        this.name = name;
        hand = new EightsHand(name);
        scoreTally = 0;
        wins = 0;
    }

    public EightsCard play(Eights eights, EightsCard prev) {
        EightsCard card = searchForMatch(prev);

        if (card == null) {
            card = drawForMatch(eights, prev);
        }

        return card;
    }

    public EightsCard searchForMatch(Card prev) {
        if (prev == null) {
            return null;
        }

        EightsHand matchingCards = new EightsHand("Matches");
        int highestRank = 0;
        int idxHighest = -1;

        for (int x = 0; x < hand.size(); x++) {
            Card card = hand.getCard(x);

            if (card.matches(prev)) {
                EightsCard matchingCard = hand.popCard(x);

                if (isEight(matchingCard)) {
                    return matchingCard;
                }

                matchingCards.addCard(matchingCard);

                // Keep track of the highest rank to play first
                if (matchingCard.getRank() > highestRank) {
                    highestRank = matchingCard.getRank();
                    idxHighest = matchingCards.size() - 1;
                }
            }
        }

        if (matchingCards.size() > 0 && idxHighest >= 0) {
            return matchingCards.popCard(idxHighest);
        }

        return null;
    }

    public EightsCard drawForMatch(Eights eights, Card prev) {
        while(true) {
            EightsCard card = eights.drawCard();
            System.out.println(name + " draws " + card);

            if (card.matches(prev)) {
                return card;
            }

            hand.addCard(card);
        }
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
            scoreTally = hand.scoreHand();
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
