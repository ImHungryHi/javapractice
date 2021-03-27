package chapter05.e;

public class Exercise {
    public static void main(String[] args) {
        boolean flag1 = isHoopy(202);   // true (202 % 2 = 0)
        boolean flag2 = isFrabjous(202); // true (202 > 0)
        System.out.println(flag1);
        System.out.println(flag2);

        // Both of these will print
        if (flag1 && flag2) {
            System.out.println("ping!");
        }
        if (flag1 || flag2) {
            System.out.println("pong!");
        }
    }

    public static boolean isHoopy(int x) {
        boolean hoopyFlag;

        if (x % 2 == 0) {
            hoopyFlag = true;
        }
        else {
            hoopyFlag = false;
        }
        // this could've been
        // hoopyFlag = x % 2 == 0;

        return hoopyFlag;
    }

    public static boolean isFrabjous(int x) {
        boolean frabjousFlag;

        if (x > 0) {
            frabjousFlag = true;
        }
        else {
            frabjousFlag = false;
        }

        return frabjousFlag;
    }
}
