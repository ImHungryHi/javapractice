package cardgame;

public class CardGame {
    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        System.out.println(card);

        Deck deck = new Deck();
        boolean stopHere = true;

        /*
        Card stringCard = new Card("King", "Hearts");
        Card stringIntCard = new Card("Queen", Suit.CLUBS);
        Card intStringCard = new Card(Rank.JACK, "Diamonds");

        System.out.println(stringCard);
        System.out.println(stringIntCard);
        System.out.println(intStringCard);
        */
    }
}
