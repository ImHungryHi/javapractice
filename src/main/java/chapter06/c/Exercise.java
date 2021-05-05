package chapter06.c;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(gauss(10, 2));
        System.out.println(gauss(10, 3));
        System.out.println(gauss(5, 5));
    }

    public static int gauss(int x, int n) {
        int i = 0;
        int exp = 1;

        while (i < Math.abs(n)) {
            if (n > 0) {
                exp *= x;
            }
            else {
                exp /= x;
            }

            i++;
        }

        return exp;
    }
}
