package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {
    public static void sort(String[] array) {
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();

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

    /*
     * -----------------------------------------------------------------------------------------
     * ------------------------------------- KNOWN METHODS -------------------------------------
     * -----------------------------------------------------------------------------------------
     */
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

        System.out.println(Arrays.toString(arrToSort));
    }

    // Not my solution
    public static void bubbleSortShort(int[] list) {
        int n = list.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(list));
    }

    // SO CALLED OPTIMAL SORTING METHOD
    public static void mergeSort(ArrayList<ArrayList<Integer>> lstList) {
        ArrayList<Integer> lstResult = new ArrayList<>();
        ArrayList<Integer> lstLowest = new ArrayList<>();
        int total = 0;
        int lowList = 0;
        int a = 0;
        int b = 0;

        for (ArrayList<Integer> list : lstList) {
            total += list.size();
        }

        for (int x = 0; x < total; x++) {
            lowList = 0;

            for (int y = 1; y < lstList.size(); y++) {
                a = lstList.get(y).get(0);
                b = lstList.get(lowList).get(0);

                if (a < b) {
                    lowList = y;
                }
            }

            lstLowest = lstList.get(lowList);
            lstResult.add(lstLowest.get(0));
            lstLowest.remove(0);

            if (lstLowest.size() > 0) {
                lstList.set(lowList, lstLowest);
            }
            else {
                lstList.remove(lowList);
            }
        }

        for (int n : lstResult) {
            System.out.println(n);
        }
    }

    /*
    public static void quickSort() {
        //
    }

    public static void heapSort() {
        //
    }

    public static void insertionSort() {
        //
    }*/

    public static void selectionSort(int[] array) {
        int idxStart = 1;
        int idxLowest = 0;

        for (int x = 0; x < array.length; x++) {
            for (int y = idxStart; y < array.length; y++) {
                if (array[idxLowest] > array[y]) {
                    idxLowest = y;
                }
            }

            if (array[x] > array[idxLowest]) {
                int temp = array[x];
                array[x] = array[idxLowest];
                array[idxLowest] = temp;
            }
        }
    }

    /*public static void countingSort() {
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
}
