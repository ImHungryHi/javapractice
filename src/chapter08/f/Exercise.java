package chapter08.f;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(max(new int[] { 2, 1, 6, 5, 3 }));
    }

    public static int max(int[] arr) {
        return maxInRange(arr,0, arr.length - 1);
    }

    public static int maxInRange(int[] range, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return range[lowIndex];
        }

        int midPoint = (highIndex + lowIndex) / 2;
        int max1 = maxInRange(range, lowIndex, midPoint);
        int max2 = maxInRange(range, midPoint + 1, highIndex);

        if (max1 > max2) {
            return max1;
        }
        else {
            return max2;
        }
    }
}




