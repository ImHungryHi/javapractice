package chapter14.d;

public class EightsHand extends Hand {
    public EightsHand(String label) {
        super(label);
    }

    public int scoreHand() {
        int tally = 0;

        for (int x = 0; x < size(); x++) {
            EightsCard card = (EightsCard) getCard(x);
            tally += card.getRank();
        }

        return tally;
    }

    public EightsCard popCard() {
        return (EightsCard) super.popCard();
    }

    public EightsCard popCard(int i) {
        return (EightsCard) super.popCard(i);
    }

    public EightsCard lastCard() {
        return (EightsCard) super.lastCard();
    }
}
