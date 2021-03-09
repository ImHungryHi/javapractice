package cardgame;

public class CardGame {
    public static void main(String[] args) {
        //Deck deck = new Deck();
        War war = new War();
        war.play();

        /*
        deck.shuffle();
        deck = deck.mergeRecursive();
        deck.showDeck();
        */

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
