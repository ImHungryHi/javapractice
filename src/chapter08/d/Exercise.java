package chapter08.d;

public class Exercise {
    public static int ack(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        else if (n == 0) {
            return ack(m - 1, n);
        }
        else {
            return ack(m - 1, ack(m, n -1));
        }
    }

    public static void main(String[] args) {
        System.out.println(ack(0, 0));
        System.out.println(ack(0, 1));
        System.out.println(ack(1, 0));
        System.out.println(ack(1, 1));
        System.out.println(ack(1, 2));
        System.out.println(ack(2, 1));
        System.out.println(ack(2, 2));
        System.out.println(ack(2, 3));
        System.out.println(ack(3, 2));
        System.out.println(ack(3, 3));
    }
}
