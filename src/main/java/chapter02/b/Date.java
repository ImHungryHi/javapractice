package chapter02.b;

public class Date {
    public static void main(String[] args) {
        String day = "monday";
        int date = 25;
        String month = "January";
        int year = 2021;
        System.out.println("Hello world");
    }

    public void printEuropean(String day, int date, int month, int year) {
        System.out.println(day + " " + date + " " + month + " " + year);
    }

    public void printAmerican(String day, int date, int month, int year) {
        System.out.println(day + ", " + month + " " + date + " " + year);
    }
}
