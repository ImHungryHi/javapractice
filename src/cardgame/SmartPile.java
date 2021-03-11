package cardgame;

import java.util.ArrayList;

// example of expanding on existing classes by inheritance
public class SmartPile extends ArrayList<Card> {
    // In the case of inheritance vs composition, the above is inheritance (with or without expansion using methods)
    //  the following fields are an example of composition. Ie adding another class's functionality as its own seperate part
    //  in a class
    //
    //public Card first = this.get(0);
    //public Card last = this.get(size() - 1);
    //
    // Don't do this btw, upon creation of a SmartPile instance, the arraylist is empty. Preferably, do this:
    public Card first, last;
    // Then initialize or update when an action is performed

    // add already exists, and so does isEmpty.
    public Card pop() {
        return remove(size() - 1);
    }

    public void addDeck(Deck deck) {
        addAll(deck.getCards());
        /*for (Card c : deck.getCards()) {
            add(c);
        }*/
    }
}
