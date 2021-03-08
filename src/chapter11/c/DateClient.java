package chapter11.c;

public class DateClient {
    public static void main(String[] args) {
        Date birthday = new Date(25, 7, 1991);
        Date newYear = new Date();

        System.out.println("1970 new year: " + newYear);
        newYear.setYear(2021);
        System.out.println("Current new year: " + newYear);
        System.out.println("My birthday: " + birthday);
        System.out.println("Is my birthday on new year? " + birthday.equals(newYear));
    }
}
