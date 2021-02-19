import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Utilities {
    private static long startTime = 0;
    private static long timeMS = 0;
    private static boolean timerStarted = false;

    public static void startTimer() {
        if (!timerStarted) {
            startTime = System.currentTimeMillis();
            timeMS = 0;
            timerStarted = true;
        }
    }

    public static long getIntervalTime() {
        if (timerStarted) return (new Date()).getTime() - startTime;

        // Default FUBAR value
        return 0;
    }

    public static long endTimer() {
        if (timerStarted) {
            timeMS = (new Date()).getTime() - startTime;
            timerStarted = false;
        }
        else timeMS = 0;

        return timeMS;
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
}
