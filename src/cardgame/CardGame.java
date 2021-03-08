package cardgame;

public class CardGame {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        Deck d2 = new Deck();
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
