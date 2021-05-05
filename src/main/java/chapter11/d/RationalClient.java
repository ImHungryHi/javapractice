package chapter11.d;

public class RationalClient {
    public static void main(String[] args) {
        // Trekkies unite!
        Rational sevenOfNine = new Rational(7, 9);
        Rational thirdOfFive = new Rational(3, 5);
        Rational twentyOfSixty = new Rational(20, 60);
        Rational fourOfEight = new Rational(4, 8);
        Rational defRational = new Rational();

        defRational.printRational();
        sevenOfNine.printRational();
        sevenOfNine.negate();   // Minus
        sevenOfNine.printRational();
        sevenOfNine.negate();   // Back to plus
        sevenOfNine.printRational();
        sevenOfNine.inverse();
        sevenOfNine.printRational();
        System.out.println("Double result of " + thirdOfFive + ": " + thirdOfFive.getDouble());
        System.out.println("Lowest terms of " + twentyOfSixty + ": " + twentyOfSixty.reduce());
        System.out.println(sevenOfNine + " + " + thirdOfFive + " = " + sevenOfNine.add(thirdOfFive));
        System.out.println(twentyOfSixty + " + " + fourOfEight + " = " + twentyOfSixty.add(fourOfEight));
    }
}
