package chapter05.c;

public class Fermat {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = 4;
        int n = 4;
        int sumExp = (int)Math.pow(a, n) + (int)Math.pow(b, n);
        int resultExp = (int)Math.pow(c, n);

        if (sumExp == resultExp && n > 2) {
            System.out.println("Holy smokes, Fermat was wrong!");
        }
        else {
            System.out.println("No, that doesn't work.");
        }
    }
}
