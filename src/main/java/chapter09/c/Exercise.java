package chapter09.c;
import java.math.BigInteger;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(pow(2, 400));
    }

    public static BigInteger pow(int x, int n) {
        if (n == 0) return BigInteger.valueOf(1);

        BigInteger t = pow(x, n / 2);
        BigInteger expT = t.multiply(t);

        if (n % 2 == 0) {
            return expT;
        }
        else {
            return expT.multiply(BigInteger.valueOf(x));
        }
    }
}
