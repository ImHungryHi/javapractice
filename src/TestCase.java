import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TestCase {
    public static void nestedLoops() {
        int x = 0, y = 0;
        System.out.println("----------------------------------------------");

        while (x++ < 10) {
            while (y++ < 10) System.out.printf("%4d", x * y);

            System.out.println();
            y = 0;
        }

        System.out.println("----------------------------------------------");

        for (x = 0; x++ < 10;) {
            for (y = 0; y++ < 10;)
                    System.out.printf("%4d", x * y);

            System.out.println();
        }

        System.out.println("----------------------------------------------");
    }

    public static void whileLoops() {
        int x = 0;

        // LOOP 10 TIMES FROM 0-9
        while (x < 10) {
            System.out.printf("%3d", x);
            x++;
        }

        x = 0;
        System.out.println();

        // LOOP 10 TIMES FROM 0-9, PRINT 1-10
        while (x++ < 10) System.out.printf("%3d", x);

        x = 0;
        System.out.println();

        // LOOP 9 TIMES FROM 1-9, PRINT 1-9
        while (++x < 10) System.out.printf("%3d", x);

        x = 0;
        System.out.println();

        // LOOP 10 TIMES FROM 0-9, PRINT 1-10
        while (10 > x++) System.out.printf("%3d", x);

        x = 0;
        System.out.println();

        // LOOP 9 TIMES FROM 1-9, PRINT 1-9
        while (10 > ++x) System.out.printf("%3d", x);
        System.out.println();
    }

    public static void forLoops() {
        for (int x = 1; x <= 10; x++) System.out.printf("%3d", x);
        System.out.println();

        // For all 4 of the below situations, the index STARTS 1 index later than the initialization
        // For these, you'll have to lower the threshold as x is incremented 1 index beyond
        for (int x = 0; 9 >= x++;) System.out.printf("%3d", x);
        System.out.println();
        for (int x = 0; x++ <= 9;) System.out.printf("%3d", x);
        System.out.println();

        // These 2 will have 1 less loop
        for (int x = 0; 10 >= ++x;) System.out.printf("%3d", x);
        System.out.println();
        for (int x = 0; ++x <= 10;) System.out.printf("%3d", x);
        System.out.println();
    }

    public static void demoOperands() {
        int a = 20, b = 20;

        System.out.println("------ ; " + a + " ; " + b + " ; START LOGICAL ------");

        // BOTH STATEMENTS WILL BE EXECUTED AND COMPARED
        if (a++ >= 20 && b++ >= 20) System.out.println(a + " ; " + b + " ; AND, both true");

        a = 20;
        b = 20;

        // ONLY THE FIRST STATEMENT WILL BE EXECUTED BECAUSE OF A SHORT CIRCUIT
        if (a++ < 20 && b++ < 20) System.out.println(a + " ; " + b + " ; AND, both false");
        else System.out.println(a + " ; " + b + " ; AND, both false - else");

        a = 20;
        b = 20;

        // ONLY THE FIRST STATEMENT WILL BE EXECUTED BECAUSE OF A SHORT CIRCUIT
        if (a++ >= 20 || b++ >= 20) System.out.println(a + " ; " + b + " ; OR, both true");

        a = 20;
        b = 20;

        // BOTH STATEMENTS WILL BE EXECUTED AND COMPARED
        if (a++ < 20 || b++ < 20) System.out.println(a + " ; " + b + " ; OR, both false");
        else System.out.println(a + " ; " + b + " ; OR, both false - else");

        a = 20;
        b = 20;
        // ---- IN ALL BITWISE CASES, BOTH STATEMENTS WILL BE EXECUTED AND COMPARED ---- //
        System.out.println("------ ; " + a + " ; " + b + " ; START BITWISE ------");
        if (a++ >= 20 & b++ >= 20) System.out.println(a + " ; " + b + " ; AND, both true");

        a = 20;
        b = 20;
        if (a++ < 20 & b++ < 20) System.out.println(a + " ; " + b + " ; AND, both false");
        else System.out.println(a + " ; " + b + " ; AND, both false - else");

        a = 20;
        b = 20;
        if (a++ >= 20 | b++ >= 20) System.out.println(a + " ; " + b + " ; OR, both true");

        a = 20;
        b = 20;
        if (a++ < 20 | b++ < 20) System.out.println(a + " ; " + b + " ; OR, both false");
        else System.out.println(a + " ; " + b + " ; OR, both false - else");
    }

    public static void timing() {
        try {
            System.out.println(Experiment.getIntervalTime());
            Experiment.startTimer();
            // println will add time to your total processing time
            System.out.println(Experiment.getIntervalTime());
            Thread.sleep(100);
            System.out.println(Experiment.getIntervalTime());
            System.out.println(Experiment.endTimer());
        }
        catch (Exception ex) {
            // Thread.sleep won't allow for uncaught exceptions, even if no exception will occur
        }
    }

    public static void tafelVanTien() {
        for (int x = 1; x <= 10; x++) {
            //for (int y = 1; 10 >= y++;)
            for (int y = 1; y <= 10; y++)
                System.out.printf("%4d", x * y);    // right align with 4 digits (fill with spaces)
            //System.out.printf("%d\t", x * y); // left align with tabs

            System.out.println();
        }
    }

    public static int indexOf(String s, char c, boolean caseSensitive) {
        if (!caseSensitive) {
            s = s.toLowerCase();
            c = Character.toLowerCase(c);
        }

        char[] arr = s.toCharArray();

        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == c) {
                return x;
            }
        }

        return -1;
    }

    public static int[] indexOfAll(String s, char c, boolean caseSensitive) {
        if (!caseSensitive) {
            s = s.toLowerCase();
            c = Character.toLowerCase(c);
        }

        ArrayList<Integer> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        int[] retArray;

        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == c) {
                list.add(x);
            }
        }

        retArray = new int[list.size()];

        for (int x = 0; x < list.size(); x++) {
            retArray[x] = list.get(x);
        }

        return retArray;
    }

    public static int countChar(String s, char c) {
        char[] arr = s.toLowerCase().toCharArray();
        int count = 0;

        for (char value : arr) {
            if (value == c) {
                count++;
            }
        }

        return count;
    }

    public static String substr(String s, int start) {
        String retValue = "";

        for (int x = start; x < s.length(); x++) {
            retValue += s.charAt(x);
        }

        return retValue;
    }

    public static String substr(String s, int start, int end) {
        String retValue = "";

        for (int x = start; x < end; x++) {
            retValue += s.charAt(x);
        }

        return retValue;
    }

    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] result = new int[size];

        for (int x = 0; x < size; x++) {
            result[x] = random.nextInt();
        }

        return result;
    }

    public static int[] randomArray(int size, int bound) {
        Random random = new Random();
        int[] result = new int[size];

        for (int x = 0; x < size; x++) {
            result[x] = random.nextInt(bound);
        }

        return result;
    }

    public static int inRange(int[] array, int low, int high) {
        int count = 0;

        for (int x : array) {
            if (x >= low && x <= high) {
                count++;
            }
        }

        return count;
    }

    public static int[] makeHistogram(int[] arr) {
        int[] result = new int[10];

        for (int x = 0; x < result.length; x++) {
            result[x] = inRange(arr, x * 10, (x * 10) + 10);
        }

        return result;
    }

    public static int[] countLetters(String str) {
        int[] counts = new int[26];
        char[] chars = str.toLowerCase().toCharArray();

        for (char c : chars) {
            // places an index between 0 and 25 (incl) as 'a' has value 97 and 'z' has value 122
            int index = c - 'a';
            counts[index]++;
        }

        return counts;
    }

    public static HashMap<Character, Integer> countLettersAlternative(String str) {
        HashMap<Character, Integer> counts = new HashMap<>();
        char[] chars = str.toLowerCase().toCharArray();

        for (char c : chars) {
            int indexer = c - 'a';

            // Only count a-z
            if (indexer >= 0 && indexer <= 25) {
                if (counts.containsKey(c)) {
                    int val = counts.get(c) + 1;
                    counts.put(c, val);
                } else {
                    counts.put(c, 1);
                }
            }
        }

        return counts;
    }

    // Get an array of prime numbers up to a limit, based on Eratosthenes' method
    public static ArrayList<Integer> sieveOfEratosthenes(int limit) {
        ArrayList<Integer> primes = new ArrayList<>();

        // Fill up, we'll go through a process of elimination later
        for (int x = 2; x <= limit; x++) {
            primes.add(x);
        }

        // Now for the real deal - loop through all numbers and cross off any numbers later on in the list
        // that aren't considered a prime number.
        // The rules are simple - a prime number is greater than 1 and divisible by only 1 and itself.
        // Any number prime number can be multiplied up to a certain limit to mark other non-prime numbers for deletion
        // Eg: 2 eliminates 4, 6, 8, 10, 12 and so on. The next unmarked number is 3, which in turn WOULD eliminate 6
        // if it hadn't already been deleted and moves on to 9, 15, 21 and so on. Repeat for 5, 13, ...
        for (int x = 0; x < primes.size(); x++) {
            int currentPrime = primes.get(x);

            for (int y = x + 1; y < primes.size(); y++) {
                int numCompare = primes.get(y);

                if (numCompare % currentPrime == 0) {
                    primes.remove(y);
                    // Offset the index, since all the others move forward 1 space
                    y--;
                }
            }
        }

        return primes;
    }
}
