package chapter09.b;

import java.math.BigInteger;

public class Big {
    public static void main(String[] args) {
        bigFactorial(30);
    }

    public static String bigFactorial(int n) {
        if (n < 0 || n > 150) return "0";

        BigInteger big = BigInteger.valueOf(1);

        for (int x = 1; x <= n; x++) {
            big = big.multiply(BigInteger.valueOf(x));
            System.out.println(big);
        }

        return big.toString();
    }
}
