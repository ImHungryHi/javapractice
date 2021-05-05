package chapter02.c;

public class Time {
    private static int hours = 15;
    private static int minutes = 10;
    private static int seconds = 10;

    public static void main(String[] args) {
        int totalSeconds = 24 * 3600;
        int secondsPassed = ((hours * 3600) + (minutes * 60) + seconds);
        int secondsLeft = totalSeconds - secondsPassed;
        double percentage = ((double)secondsPassed / totalSeconds) * 100;
        System.out.println("Seconds since midnight = " + secondsPassed);
        System.out.println("Seconds to midnight = " + secondsLeft);
        System.out.println("Percentage of day = " + percentage + "%");

        minutes = 15;
        seconds = 23;
        int exerciseEnd = ((hours * 3600) + (minutes * 60) + seconds);
        System.out.println("Passed seconds since start = " + (exerciseEnd - secondsPassed));
    }
}
