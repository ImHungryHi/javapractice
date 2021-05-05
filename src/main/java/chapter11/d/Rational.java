package chapter11.d;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void negate() {
        this.numerator = -this.numerator;
    }

    public void inverse() {
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
    }

    public Rational reduce() {
        int divisor = getEuclidsDivisor(this.numerator, this.denominator);
        return new Rational(this.numerator / divisor, this.denominator / divisor);
    }

    public Rational add(Rational that) {
        int numerator, denominator;

        if (this.denominator == that.denominator) {
            numerator = this.numerator + that.numerator;
            denominator = this.denominator;
        }
        else {
            numerator = (this.numerator * that.denominator) + (that.numerator * this.denominator);
            denominator = this.denominator * that.denominator;
            int euclid = getEuclidsDivisor(numerator, denominator);

            numerator /= euclid;
            denominator /= euclid;
        }

        return new Rational(numerator, denominator);
    }

    public double getDouble() {
        double dResult = (double)this.numerator / this.denominator;
        return dResult;
    }

    public void printRational() {
        System.out.println(this);
    }

    private int getEuclidsDivisor(int n, int m) {
        if (m == 0) {
            return n;
        }

        return getEuclidsDivisor(m, n % m);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
