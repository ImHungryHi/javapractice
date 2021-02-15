import java.util.Date;
import java.util.Collections;
import java.util.ArrayList;

public class Experiment {
    private static long startTime = 0;
    private static long timeMS = 0;
    private static boolean timerStarted = false;

    public static void bubbleSort () {
        boolean notFinished = true, stoppedSwitching;
        int[] arrToSort = { 7, 3, 4, 1, 2, 8, 9 };
        int x = 0, y = 1, endY = arrToSort.length, intMaxSorted = 0, intRun = 0;
        int maxY = endY - 1;

        while (notFinished) {
            if (arrToSort[x] > arrToSort[y]) {
                int temp = arrToSort[y];
                arrToSort[y] = arrToSort[x];
                arrToSort[x] = temp;
                intMaxSorted = x;
                stoppedSwitching = false;
            }
            else {
                stoppedSwitching = true;
            }

            /*if (y == endY) {
                // Reset or close
                maxY = endY - 3;
            }*/
            if (y != endY) {
                if (y == maxY) {
                    x = 0;
                    y = 1;
                    maxY -= 2;
                }
                else {
                    if (intMaxSorted > x) {
                        intMaxSorted = 0;
                    }

                    x++;
                    y++;
                }
            }

            if (intRun >= endY && intMaxSorted == 0 && stoppedSwitching) {
                notFinished = false;
            }

            intRun++;
            // bubble sort takes 2 digits per iteration, compares and switches when the second one is less than the first
            // on the first run, the last and penultimate numbers will already be in the correct position
            // on the next runs, the "limit" we set for the last checks will come sooner and sooner
        }
    }

    /* SO CALLED OPTIMAL SORTING METHOD
    public static void mergeSort() {
        //
    }

    public static void quickSort() {
        //
    }

    public static void heapSort() {
        //
    }

    public static void insertionSort() {
        //
    }

    public static void selectionSort() {
        //
    }

    public static void countingSort() {
        //
    }

    public static void introSort() {
        //
    }
    /* END OF SO CALLED OPTIMAL SORTING METHODS */

    public static void bucketSort() {
        //
    }

    public static void nonComparisonSort() {
        //
    }

    public static void radixSort() {
        //
    }

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

    public static void sort(String[] array) {
        ArrayList<String> strings = new ArrayList();
        ArrayList<Integer> numbers = new ArrayList();

        for (String s : array) {
            // try-catch turned into an if-else
            try {
                int num = Integer.parseInt(s);
                numbers.add(num);
            } catch (NumberFormatException ex) {
                // item is String, not Integer
                strings.add(s);
            }
        }

        Collections.sort(strings);
        numbers.sort(Collections.reverseOrder());
        int stringId = 0, numId = 0;

        for (int i = 0; i < array.length; i++) {
            try {
                int num = Integer.parseInt(array[i]);
                array[i] = numbers.get(numId++).toString();
            }
            catch (NumberFormatException ex) {
                array[i] = strings.get(stringId++);
            }
        }
    }

    public static boolean isNumeric(String s) {
        try {
            int num = Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}
