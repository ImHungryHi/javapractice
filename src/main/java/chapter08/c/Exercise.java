package chapter08.c;

/**
 * Diagram of last invocation before end of prod:
 * prod(1, 4) => recurse = 6; result = 24;
 * prod(1, 3) => recurse = 2; result = 6;
 * prod(1, 2) => recurse = 1; result = 2;
 * prod(1, 1) => return 1; (becomes recurse value in prod(1, 2))
 * => recurse only gets filled when the next prod gets invoked so the stack stays empty until then and fills in
 *     from bottom to top (n=1 -> n=2 -> n=3 -> n=4 ...)
 * -------------------------------------------------
 * Program result: 24
 * -------------------------------------------------
 * Description: the purest form of a factorial calculation wherein all numbers from m to n get multiplied with one another
 *   Careful though: whenever m > n, we encounter an infinite loop as n never reaches m
 */

public class Exercise {
    public static void main(String[] args) {
        System.out.println(prod(1, 4));
    }

    public static int prod(int m, int n){
        if (m == n) {
            return n;
        }
        else {
            int recurse = prod(m, n - 1);
            int result = n * recurse;
            return result;
        }
    }

    // Same thing, just shorter
    public static int prodNew(int m, int n) {
        if (m == n) {
            return n;
        }
        else {
            return n * prod(m, n - 1);
        }
    }
}
