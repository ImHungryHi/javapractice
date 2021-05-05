package chapter11.a;

public class Time {
    private static int count = 0;
    private int hour;
    private int minute;
    private double second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0.0;
    }

    public Time(int hour, int minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        parseCorrect();
    }

    private void parseCorrect() {
        if (this.second >= 60.0) {
            this.minute += (int) (this.second / 60);
            this.second %= 60.0;
        }
        if (this.minute >= 60) {
            this.hour += (int) (this.minute / 60);
            this.minute %= 60;
        }
        if (this.hour >= 24) {
            this.hour %= 24;
        }
    }

    public void increment(int seconds) {
        this.second += seconds;
        parseCorrect();
    }

    public void add(Time that) {
        this.hour += that.hour;
        this.second += that.minute;
        this.second += that.second;
        parseCorrect();
    }

    public static Time add(Time t1, Time t2) {
        return new Time((t1.hour + t2.hour), (t1.minute + t2.minute), (t1.second + t2.second));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Time)) {
            return false;
        }

        Time that = (Time) obj;
        return (this.hour == that.hour) && (this.minute == that.minute) && (this.second - that.second <= 0.0001) && (this.second - that.second >= -0.0001);
    }

    @Override
    public String toString() {
        return (this.hour < 10 ? "0" : "") + this.hour + ":" + (this.minute < 10 ? "0" : "") + this.minute + ":" + (this.second < 10.0 ? "0" : "") + this.second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public double getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour % 24;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        parseCorrect();
    }

    public void setSecond(double second) {
        this.second = second;
        parseCorrect();
    }
}
