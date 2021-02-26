package cardgame;

public class CardGame {
    private Card[] deck;
    private final int DECKSIZE = 52;

    public CardGame() {
        initialize();
    }

    public void initialize() {
        this.deck = new Card[DECKSIZE];

        for (int x = 0; x <= Suit.MAX; x++) {
            for (int y = 0; y < Rank.MAX; y++) {
                // We multiply the SUIT index with the RANK maximum to get to the following SUIT's first index
                int idx = (x * Rank.MAX) + y;
                this.deck[idx] = new Card((y + 1), x);
            }
        }
    }

    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        Card stringCard = new Card("King", "Hearts");
        Card stringIntCard = new Card("Queen", Suit.CLUBS);
        Card intStringCard = new Card(Rank.JACK, "Diamonds");

        System.out.println(card);
        System.out.println(stringCard);
        System.out.println(stringIntCard);
        System.out.println(intStringCard);

        CardGame game = new CardGame();
    }
}
