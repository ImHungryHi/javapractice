package cardgame;

public class CardGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Deck d1 = deck.subDeck(0, 25);
        Deck d2 = deck.subDeck(25, 51);
        Deck d3 = Deck.merge(d1, d2);
        d3.showDeck();

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
