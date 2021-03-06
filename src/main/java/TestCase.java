import code.Collections;
import code.Recursive;
import code.Sorting;

import java.awt.*;
import java.math.BigInteger;
import java.util.*;

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
    // Integers compare by using the reference to their value instead of their value itself.
    // The edge case being that they can be compared correctly if they are not over 127... (auto-boxing)
    // This is because the virtual machine optimizes the code because numbers up to 127 are stored in the cache.
    // It is a preset limit that is just there, a decision was made for any weird reason.
    // The reference will be the same for -128 to 127 because these are already stored in cache.
    public static int compareAutoBoxing() {
        Integer a = 100, b = 100;   // TRUE
        //Integer a = 128, b = 128; // FALSE
        if (a == b) return 0;
        else if (a < b) return -1;
        return 1;

        // Use a.equals(b) instead
    }

    public static void doBubbleSort() {
        int[] list = { 8, 9, 15, 7, 1, 1};
        Sorting.bubbleSortShort(list);
    }

    public static void doBubbleRecursive() {
        int[] list = { 8, 9, 15, 7, 1, 1};
        System.out.println(Arrays.toString(list));
        Recursive.bubbleSort(list, list.length - 1);
        System.out.println(Arrays.toString(list));
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

    public static ArrayList<int[]> inlineArrays() {
        ArrayList<int[]> list = new ArrayList<int[]>();

        list.add(new int[]{1, 2, 3, 4, 5});
        list.add(new int[]{1, 2});
        list.add(new int[]{4, 3, 2, 1});
        list.add(new int[]{0, 0, 0, 0, 0, 0, 0});
        list.add(new int[0]);

        return list;
    }

    // kan wel nog optimaliseren door de eerste helft om te rekenen naar eenheden, tientallen enz en da te vergelijken me den tweede helft
    public static ArrayList<Integer> palindromicNumbers(int limit) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int x = 0; x <= limit; x++) {
            ArrayList<Integer> digits = new ArrayList<Integer>();
            long y = 1, rest = 0, tailingZeroes = 0;

            while (true) {
                long pow = (long)Math.pow(10, y++);   // 10 100 1000 ...
                rest = x % pow;   // 0 90 890 ...

                if (rest == 0) tailingZeroes++;

                if (rest < 10) digits.add((int)rest);
                else {
                    int addable = (int)(rest / (pow / 10));
                    digits.add(addable);
                }

                if (rest >= x) break;
            }

            int lastIndex = digits.size() - 1;
            int reverse = 0;

            // Cleanup
            for (int z = lastIndex; z >= 0; z--) {
                reverse += digits.get(z) * (int)Math.pow(10, (lastIndex - z));
            }

            int tailingComparable = (int)(x / (int)Math.pow(10, tailingZeroes));

            if (tailingComparable == reverse) {
                list.add(x);
            }
        }

        return list;
    }

    public static ArrayList<Integer> palindromicNumbersString(int limit) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int x = 0; x <= limit; x++) {
            String sNum = Integer.toString(x);
            StringBuilder reverse = new StringBuilder();

            for (char cNum : sNum.toCharArray()) {
                reverse.insert(0, cNum);
            }

            if (sNum.equals(reverse.toString())) list.add(x);
        }

        return list;
    }

    public static Integer parseInteger(String s) {
        // There is no real performance difference between valueOf and parseInt.
        // The only difference you'll find is when you want the object Integer - use valueOf - and when you
        //   want the primitive int - use parseInt.
        int a = Integer.parseInt(s);
        Integer b = Integer.valueOf(s);
        Integer c = Integer.valueOf(a); // You can also parse the primitive into an object
        Integer d = a;                  //   or straight up put the value of a primitive into the object

        // You can return any of the above
        return a;
    }

    public static void pointingFingers() {
        Point pnt = new Point(3, 4);
        int x = pnt.x;
        int y = pnt.y;
    }

    public static void pointFingers(Point point) {
        point.x = 1;                    // These lines will actually change the values beyond this scope
        point.y = 2;                    //    since we use the reference to point in the parameter to change the content
        System.out.println(point);
        point = new Point(5, 6);    // This will make it so that we overwrite the reference and change the scope
        //    so that the values of point only change within this method. the object in the calling method
        //    won't change
        System.out.println(point);
    }

    public static void printEratosthenesAlt() {
        boolean[] eratosthenes = TestCase.eratosthenesAlternative(100);
        for (int i = 0; i < eratosthenes.length; i++) System.out.print(i % 10);
        System.out.println();
        for (int i = 0; i < eratosthenes.length; i++) System.out.print((eratosthenes[i] ? 1 : 0));
        System.out.println();
        for (int i = 0; i < eratosthenes.length; i++) System.out.print((eratosthenes[i] ? "" : i + ";"));
    }

    public static void printFactorial(int n) {
        System.out.println(Recursive.getFactorial(n));
    }

    public static void printFibonacci(int n) {
        int fibo = Recursive.getFibonacci(0, 1, n);
        System.out.println("\nBiggest Fibonacci number beneath " + n + " = " + fibo);
    }

    public static void printFibonacciEven(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Recursive.fibonacciEven(n, list);
        System.out.println(list.toString());

        int sum = 0;
        for (int i : list) sum += i;
        System.out.println("Sum of all even Fibonacci numbers = " + sum);
    }

    public static void printNFibonacci(int n) {
        System.out.println("\nNumber " + n + " in the sequence of fibonacci = " + Recursive.getNFibonacci(n));
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

    public static int sumOf3And5Multiples(int limit) {
        int sum = 0;

        for (int x = 3; x < limit; x += 3) {
            sum += x;
        }

        for (int x = 5; x <= limit; x += 5) {
            if (x % 3 != 0) sum += x;
        }

        return sum;
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

    public static void compareBubbleSortTiming() {
        System.out.println("Bubble sort comparison");

        int[] arrInput = { 7, 3, 4, 1, 2, 8, 9 };
        Utilities.startTimer();
        Sorting.bubbleSort();   // 4ms
        long myTime = Utilities.endTimer();
        Utilities.startTimer();
        Sorting.bubbleSortShort(arrInput);  // 0ms
        long alternativeTime = Utilities.endTimer();

        System.out.println("My time = " + myTime + "; Alternative time = " + alternativeTime + "\nDifference = " + (myTime - alternativeTime) + "\n");
    }

    public static void compareEratosthenesTiming() {
        System.out.println("Eratosthenes comparison");

        Utilities.startTimer();
        sieveOfEratosthenes(1000);  // 8ms
        long myTime = Utilities.endTimer();
        Utilities.startTimer();
        eratosthenesAlternative(1000);  // 0ms
        long alternativeTime = Utilities.endTimer();

        System.out.println("My time = " + myTime + "; Alternative time = " + alternativeTime + "\nDifference = " + (myTime - alternativeTime) + "\n");
    }

    public static void compareFactorialTiming() {
        System.out.println("Factorial comparison");

        Utilities.startTimer();
        long fact = Recursive.getFactorial(20);   // 0ms
        long myTime = Utilities.endTimer();
        Utilities.startTimer();
        long factShort = Recursive.getFactorialShort(20);  // 1ms
        long alternativeTime = Utilities.endTimer();
        Utilities.startTimer();
        long factTail = Recursive.getFactorialTail(20, 1);
        long tailTime = Utilities.endTimer();

        System.out.println("My time = " + myTime + "; Alternative time = " + alternativeTime + "\nTail time = " + tailTime + "\n");
    }

    public static void compareFibonacciTiming() {
        System.out.println("Fibonacci comparison");

        Utilities.startTimer();
        Recursive.getFibonacci(0, 1, 1000); // 0s
        long myTime = Utilities.endTimer();
        Utilities.startTimer();
        Recursive.getFibonacciShort(0, 1, 1000);    // 17s
        long alternativeTime = Utilities.endTimer();

        System.out.println("\nMy time = " + myTime + "; Alternative time = " + alternativeTime + "\nDifference = " + (myTime - alternativeTime) + "\n");
    }

    public static void compareNumericPalindromeTiming() {
        System.out.println("Palindrome comparison");

        Utilities.startTimer();
        ArrayList<Integer> nonString = palindromicNumbers(10000000); // 0s
        long nonStringTime = Utilities.endTimer();
        Utilities.startTimer();
        ArrayList<Integer> stringCompared = palindromicNumbersString(10000000); // 0s
        long stringTime = Utilities.endTimer();

        System.out.println("\nNon-string time = " + nonStringTime + "; String time = " + stringTime + "\nDifference = " + (nonStringTime - stringTime) + "\n");
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

    public static void hashSetDemo() {
        Set<code.Collections.Cat> cats = code.Collections.createCats();
        Set<code.Collections.Dog> dogs = code.Collections.createDogs();

        Set<Object> pets = Collections.join(cats, dogs);
        code.Collections.printPets(pets);

        code.Collections.removeCats(pets, cats);
        code.Collections.printPets(pets);
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

    public static String bigFactorial(int n) {
        if (n < 0 || n > 150) return "0";

        BigInteger big = BigInteger.valueOf(1);

        for (int x = 1; x <= n; x++) {
            big = big.multiply(BigInteger.valueOf(x));
        }

        return big.toString();
    }
}
