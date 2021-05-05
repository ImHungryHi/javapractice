package chapter03.c;

public class Exercise {
    public static void main(String[] args) {
        int time = 33241;
        int hours = time / 3600;
        int minutes = (time - (hours * 3600)) / 60;
        int seconds = time % 60;
        int shouldBeSameAsTime = (hours * 3600) + (minutes * 60) + seconds;

        System.out.printf("%d = %d:%d:%d from %d", time, hours, minutes, seconds, shouldBeSameAsTime);
        System.out.println();
        anotherMethodOfDoingThis(time);
    }

    public static void anotherMethodOfDoingThis(int time) {
        int seconds = time % 60;
        int minutes = ((time - seconds) % 3600) / 60;
        int hours = (time - seconds - (minutes * 60)) / 3600;

        System.out.printf("%d = %d:%d:%d", time, hours, minutes, seconds);
    }
}
