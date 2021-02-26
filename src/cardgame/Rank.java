package cardgame;

public final class Rank {
    public static final int MIN = 1;
    public static final int MAX = 13;
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final String[] NAMES = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

    private Rank() {
        // Don't allow initializing
    }
}
