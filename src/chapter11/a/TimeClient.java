package chapter11.a;

public class TimeClient {
    public static void main(String[] args) {
        Time tZero = new Time();
        Time t1 = new Time(13, 50, 49.5);
        Time t2 = new Time(11, 11, 11.0);

        System.out.println("No overflow: " + Time.add(tZero, t1));
        System.out.println("Overflow: " + Time.add(t1, t2));
        System.out.println("No overflow: " + Time.add(t2, t2));

        t1.add(t1);
        System.out.println("Added non-static" + t1);

        t1.increment(200);
        System.out.println("Added 200 seconds: " + t1);

        System.out.println("T1 equals T2? " + t1.equals(t2));
        System.out.println("T1 equals T1? " + t1.equals(t1));
    }
}
