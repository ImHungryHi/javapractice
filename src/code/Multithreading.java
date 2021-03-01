package code;

// Starting from chapter 16
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

    public static class SequentialThread implements Runnable {
        private String name;

        public SequentialThread(String name) {
            this.name = name;
        }

        public void run() {
            for (int x = 0; x < 10; x++) {
                System.out.println(name + " " + x);
            }
        }
    }

    public static void sequentialThreading() throws InterruptedException {
        Thread firstThread = new Thread(new SequentialThread("First"));
        Thread secondThread = new Thread(new SequentialThread("Second"));
        firstThread.start();
        // Use the join command to run secondThread AFTER firstThread is entirely finished
        firstThread.join();     // Throws an InterruptedException
        secondThread.start();
    }
}
