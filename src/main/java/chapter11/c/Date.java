package chapter11.c;

public class Date {
    private int year, month, day;

    public Date() {
        day = 1;
        month = 1;
        year = 1970;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return (day < 10 ? "0" : "") + day + "/" + (month < 10 ? "0" : "") + month + "/" + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date)) {
            return false;
        }

        Date that = (Date) obj;
        return this.year == that.year && this.month == that.month && this.day == that.day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
