package chapter03.a;

public class Exercise {
    public static void main(String[] args) {
        int i = 10;
        double d = 15.5;
        // Correct
        System.out.printf("%d  %f", i, d);
        // Incorrect, compile error
        //System.out.printf("%f  %d", i, d);    // IllegalFormatConversionException
        //System.out.printf("%d  %f", i);   // MissingFormatArgumentException
    }
}
