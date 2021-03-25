package chapter04.b;

public class Exercise {
    public static void main(String[] args) {
        /**
         * Parameter of blimp when baffle gets called: "rattle"
         * Output:
         * ik
         * rattle
         * ping zoop
         * boo-wa-ha-ha
         */
        zippo("rattle", 13);
    }

    public static void baffle (String blimp) {
        System.out.println(blimp);  // 2
        zippo("ping", -5);
    }

    public static void zippo(String quince, int flag) {
        if (flag < 0) {
            System.out.println(quince + " zoop");   // 3
        }
        else {
            System.out.println("ik");   // 1
            baffle(quince);
            System.out.println("boo-wa-ha-ha"); // 4
        }
    }
}
