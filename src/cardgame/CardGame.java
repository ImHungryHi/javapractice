package cardgame;

public class CardGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle(5);
        deck.showDeck();
        System.out.println(deck.indexLowest(45, 51));

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
