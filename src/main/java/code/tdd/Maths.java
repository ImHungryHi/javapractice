package code.tdd;
import java.util.*;

// Prepare to be frustrated by the minutia of TDD...
public class Maths {
    public static List<Integer> PrimeFactorsOf_V1(int n) {
        return new ArrayList<Integer>();
    }

    public static List<Integer> PrimeFactorsOf_V2(int n) {
        List<Integer> result = new ArrayList<>();

        if (n > 1) {
            result.add(2);  // Ooooh, the frustration... But the test will pass and return empty for 1 and asList(2) for 2
        }

        return result;
    }
}
