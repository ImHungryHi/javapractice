public class Recursive {
    public static void samIAm(String[] arrInput, String prefix) {
        if (arrInput.length == 1)
            System.out.println(prefix + arrInput[0]);

        for (int x = 0; x < arrInput.length; x++) {
            String[] passThrough = new String[arrInput.length - 1];
            int i = 0;

            for (int y = 0; y < arrInput.length; y++) {
                if (!arrInput[y].equals(arrInput[x])) {
                    passThrough[i] = arrInput[y];
                    i++;
                }
            }

            samIAm(passThrough, prefix + arrInput[x]);
        }
    }

    public static int getFactorial(int n) {
        if (n == 2) return n;
        return n * getFactorial(n - 1);
    }

    public static int getFactorialShort(int n) {
        return (n == 2) ? n : n * getFactorial(n - 1);
    }

    public static int getFibonacci(int n, int m, int limit) {
        System.out.print(n + ";");

        if (m <= limit) {
            return getFibonacci(m, (n + m), limit);
        }
        else {
            System.out.print(m + ";");
            return n;
        }
    }

    public static int getFibonacciShort(int n, int m, int limit) {
        return (m <= limit) ? getFibonacci(m, (n + m), limit) : n;
    }
}
