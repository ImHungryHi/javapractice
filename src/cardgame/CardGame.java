package cardgame;

public class CardGame {
    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        System.out.println(card);

        Card stringCard = new Card("Ace", "Spades");
        System.out.println(stringCard);
    }
}
