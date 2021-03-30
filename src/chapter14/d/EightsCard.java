package chapter14.d;

public class EightsCard extends Card {
    public EightsCard(int rank, int suit) {
        super(rank, suit);
    }

    public boolean matches(EightsCard that) {
        boolean isEight = this.getRank() == 8;
        return super.matches(that) || isEight;
    }
}
