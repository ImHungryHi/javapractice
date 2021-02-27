package code;

public class Multithreading {
    public static class ParallelloPipidoen implements Runnable {
        public void run() {
            System.out.println("I'm being run in parallel");
        }
    }

    // You say tomàto, I say tomáto...
    public static class OtherWorldly extends Thread {
        public void run() {
            System.out.println("Me too!");
        }
    }

    public static void helloWorld() {
        ParallelloPipidoen ppp = new ParallelloPipidoen();
        Thread thread = new Thread(ppp);
        OtherWorldly parallelThread = new OtherWorldly();
        thread.start();
        parallelThread.start();
    }
}
