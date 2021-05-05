package chapter08.e;

public class Exercise {
    // I made this double because there's also such a thing as negative exponents
    public static double power(double x, double n) {
        if (n < 0) {
            return 1 / (x * power(x, -n - 1));
        }
        else if (n == 0) {
            return 1;
        }
        else {
            return x * power(x, n - 1);
        }
    }

    public static double powerEff(double x, double n) {
        if (n % 2 == 0 && n > 0) {
            double halfExp = powerEff(x, n / 2);
            return halfExp * halfExp;
        }
        else if (n % 2 == 0 && n < 0) {
            double halfExp = powerEff(x, -n / 2);
            return 1 / (halfExp * halfExp);
        }
        else if (n < 0) {
            return 1 / (x * power(x, -n - 1));
        }
        else if (n == 0) {
            return 1;
        }
        else {
            return x * powerEff(x, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(powerEff(5, 2));
        System.out.println(powerEff(5, -2));
        System.out.println(powerEff(5, 3));
        System.out.println(powerEff(5, 1));
        System.out.println(powerEff(5, 0));
    }
}
