import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestCase {
    /*
     * -----------------------------------------------------------------------------------------
     * -------------------------------------- INTRIGUING ---------------------------------------
     * -----------------------------------------------------------------------------------------
     */
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

    public static boolean[] eratosthenesAlternative(int limit) {
        // Create an array of booleans from 0 to limit (incl) where all are defaulted to false (=prime so to speak)
        // Cross off a number as being "no prime" by setting to true
        boolean[] numbers = new boolean[limit + 1];
        numbers[0] = true;
        numbers[1] = true;

        for (int n = 2; n < (limit + 1); n++) {
            if (!numbers[n]) {
                for (int i = n * 2; i < (limit + 1); i += n) {
                    numbers[i] = true;
                }
            }
        }

        return numbers;
    }

    /*
     * -----------------------------------------------------------------------------------------
     * ------------------------------------ OUT OF INTEREST ------------------------------------
     * -----------------------------------------------------------------------------------------
     */
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

    public static void printEratosthenesAlt() {
        boolean[] eratosthenes = TestCase.eratosthenesAlternative(100);
        for (int i = 0; i < eratosthenes.length; i++) System.out.print(i % 10);
        System.out.println();
        for (int i = 0; i < eratosthenes.length; i++) System.out.print((eratosthenes[i] ? 1 : 0));
        System.out.println();
        for (int i = 0; i < eratosthenes.length; i++) System.out.print((eratosthenes[i] ? "" : i + ";"));
    }

    public static void sayHello() {
        System.out.println("Twas brillig and the slithy toves\n" +
                "did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves\n" +
                "and the mome raths outgrabe.\n" +
                "\n" +
                "Beware the Jabberwock, my son.\n" +
                "The jaws that bite, the claws that catch.\n" +
                "Beware the Jubjub bird and shun\n" +
                "the frumious Bandersnatch.\n" +
                "\n" +
                "He took his vorpal sword in hand.\n" +
                "Long time the manxome foe he sought.\n" +
                "So rested he by the Tumtum tree\n" +
                "and stood awhile in thought.\n" +
                "\n" +
                "And as in uffish thought he stood;\n" +
                "the Bandersnatch, with eyes of flame,\n" +
                "came whiffling through the Tulgey wood\n" +
                "and burbled as it came.\n" +
                "\n" +
                "One, two! One, two! And through! And Through!\n" +
                "His vorpal blade went snicker-snack.\n" +
                "He left it dead, and with its head\n" +
                "he went galumphing back.\n" +
                "\n" +
                "And hast thou slain the Jabberwock?\n" +
                "Come to my arms, my beamish boy.\n" +
                "Oh frabjous day! Calloo, callay!\n" +
                "He chortled in his joy.\n" +
                "\n" +
                "Twas brillig and the slithy toves\n" +
                "did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves\nand the mome raths outgrabe.\n" +
                "\n" +
                "Lewis Carroll - Jabberwocky");
    }

    public static void stringOperations() {
        String s = "Twas brillig and the slithy toves did gyre and gimble in the wabe.";

        for (int x = 0; x < s.length(); x++) {
            int idx = x % 10;
            System.out.print(idx);
        }

        System.out.println("\n" + s + ";'b' can be found at idx " + Utilities.indexOf(s, 'b', false));
        System.out.println("'b' can be found at indexes " + Arrays.toString(Utilities.indexOfAll(s, 'b', false)));
        System.out.println("And the count of 't' is " + Utilities.countChar(s, 't'));
        System.out.println("Substring 4-10 = \"" + Utilities.substr(s, 4, 10) + "\"");
        System.out.println("Substring from 5 onward = \"" + Utilities.substr(s, 5) + "\"");

        HashMap<Character, Integer> counts = Utilities.countLettersAlternative(s);
        System.out.println(counts.toString());
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

    public static void timing() {
        try {
            System.out.println(Utilities.getIntervalTime());
            Utilities.startTimer();
            // println will add time to your total processing time
            System.out.println(Utilities.getIntervalTime());
            Thread.sleep(100);
            System.out.println(Utilities.getIntervalTime());
            System.out.println(Utilities.endTimer());
        }
        catch (Exception ex) {
            // Thread.sleep won't allow for uncaught exceptions, even if no exception will occur
        }
    }

    /*
     * -----------------------------------------------------------------------------------------
     * ----------------------------------------- LOOPS -----------------------------------------
     * -----------------------------------------------------------------------------------------
     */
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

    /*
     * -----------------------------------------------------------------------------------------
     * ------------------------------- CODEGYM USEFUL TO REMEMBER ------------------------------
     * -----------------------------------------------------------------------------------------
     */

    public static double getDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow((double) (x1 - x2), 2) + Math.pow((double) (y1 - y2), 2));
    }

    public static int sumDigitsInNumber(int number) {
        int digits = String.valueOf(number).length();
        int sum = 0, intermediary = number;
        int[] numbers = new int[digits];

        for (int x = (digits - 1); x >= 0; x--) {
            int temp = (int) (number / Math.pow(10, x));
            number = number - (int) (temp * Math.pow(10, x));
            sum += temp;
        }

        return sum;
    }
}
