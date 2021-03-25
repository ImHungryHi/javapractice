package chapter04.f;

public class Multadd {
    public static void main(String[] args) {
        System.out.println(multadd(1.0, 2.0, 3.0));
        double piFourth = Math.PI / 4;
        //double a = Math.sin(piFourth) + (Math.cos(piFourth) / 2);
        System.out.println(multadd(0.5, Math.cos(piFourth), Math.sin(piFourth)));
        //double b = Math.log(10.0) + Math.log(20.0);
        System.out.println(Math.log(10) + multadd(2.0, Math.log(2), 5.0));
        System.out.println(expSum(5));
    }

    public static double multadd(double a, double b, double c) {
        return a * b + c;
    }

    public static double expSum(double x) {
        return multadd(x, Math.exp(-x), Math.sqrt(1 - Math.exp(-x)));
    }
}
