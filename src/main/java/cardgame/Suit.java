package cardgame;

public final class Suit {
    public static final int MIN = 0;
    public static final int MAX = 3;
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;
    public static final String[] NAMES = { "Clubs", "Diamonds", "Hearts", "Spades" };

    private Suit() {
        // Don't allow initializing
    }
}
