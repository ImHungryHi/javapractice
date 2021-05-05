package chapter08.a;

public class Exercise {
    public static void main(String[] args) {
        bottlesOfBeer(99);
    }

    public static void bottlesOfBeer(int n) {
        String onTheWall = "on the wall,";
        String bottles = "bottles of beer";
        String takeDown = "ya' take one down, ya' pass it around,";
        System.out.println("--------------------------------------");

        if (n > 0) {
            System.out.println(n + " " + bottles + " " + onTheWall);
            System.out.println(n + " " + bottles + "\n" + takeDown);
            System.out.println(n + " " + bottles + " " + onTheWall);
            bottlesOfBeer(n - 1);
        }
        else {
            System.out.println("No " + bottles + " " + onTheWall);
            System.out.println("No " + bottles + "\nya' can't take one down, ya' can't pass it around,");
            System.out.println("'cause there are no more " + bottles + " " + onTheWall);
        }
    }
}
