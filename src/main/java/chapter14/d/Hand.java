package chapter14.d;

public class Hand extends CardCollection {
    public Hand(String label) {
        super(label);
    }

    public void display() {
        System.out.println(getLabel() + ": ");

        for (int x = 0; x < size(); x++) {
            System.out.println(getCard(x));
        }

        System.out.println();
    }
}
