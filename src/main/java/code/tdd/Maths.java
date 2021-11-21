package code.tdd;
import java.util.*;

// Prepare to be frustrated by the minutia of TDD...
public class Maths {
    public static List<Integer> PrimeFactorsOf_V1(int n) {
        return new ArrayList<Integer>();
    }

    public static List<Integer> PrimeFactorsOf_V2(int n) {
        List<Integer> result = new ArrayList<>();

        if (n > 1)
            result.add(2);  // Ooooh, the frustration... But the test will pass and return empty for 1 and asList(2) for 2

        return result;
    }

    public static List<Integer> PrimeFactorsOf_V3(int n) {
        List<Integer> result = new ArrayList<>();

        if (n > 1)
            result.add(n);  // Fails if n == 3, so add n (for now)

        return result;
    }

    public static List<Integer> PrimeFactorsOf_V4(int n) {
        List<Integer> result = new ArrayList<>();
        int remainder = n;

        if (remainder > 1) {
            if (remainder % 2 == 0) {
                result.add(2);
                remainder /= 2;
            }
        }

        if (remainder > 1)
            result.add(remainder);

        return result;
    }

    public static List<Integer> PrimeFactorsOf_V5(int n) {
        List<Integer> result = new ArrayList<>();
        int remainder = n;

        if (remainder > 1) {
            while (remainder % 2 == 0) {    // imagine a while loop saving our lives
                result.add(2);
                remainder /= 2;
            }
        }

        if (remainder > 1)
            result.add(remainder);

        return result;
    }
}
