package chapter08.b;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(oddSum(1));
        System.out.println(oddSum(11));
        System.out.println(oddSum(10));
        System.out.println(oddSum(99));
        System.out.println(oddSum(57));
        System.out.println(oddSum(13));
    }

    public static int oddSum(int num) {
        if (num == 1) {
            return 1;
        }
        else if (num % 2 == 0 || num < 1) {
            return 0;
        }

        return num + oddSum(num - 2);
    }
}
