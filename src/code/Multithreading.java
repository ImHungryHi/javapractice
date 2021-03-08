package code;

import java.util.ArrayList;
import java.util.List;

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

    /*
     * ------------- First join example -------------
     */
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

    public static void aufgepasst() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            // Watch out when calling the currentThread method - it doesn't get the OtherThread object's thread but rather the "main" one
            // In this case, you call the thread from the Multithreading class, but this doesn't implement or inherit any threading capabilities.
            new OtherThread();
            Thread.currentThread().join();
            // Use this instead, you'll actually join OtherThread's thread instance.
            new OtherThread().join();
            // Although I would prefer declaring and initializing an object
            OtherThread t = new OtherThread();
            t.join();

            // Keep this in mind to avoid infinite loops and other shenanigans.
        }
    }

    /*
     * ------------- Horse join example -------------
     */
    public static void startHorsingAround() throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) { }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;

        for (Horse horse : horses) {
            if (!horse.isFinished()) {
                System.out.println("Waiting for " + horse.getName());
                horse.join();   // Wait for the horse to finish before incrementing the counter
            }
            else {
                finishedCount++;
            }
        }

        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i < horseCount + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   // Delay
                s += "" + i;
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }

    /*
     * ------------- Making a clock that ticks once a second and tocks half a second later -------------
     */
    private void printTickTock() throws InterruptedException {
        System.out.println("Tick");
        Thread.sleep(500);
        System.out.println("Tock");
        Thread.sleep(500);
    }

    /*
     * ------------- Making a clock that ticks once a second until stopped -------------
     */
    public static class TickTock implements Runnable {
        private boolean hasEnded = false;
        private boolean flipFlop = false;

        public void run() {
            hasEnded = false;
            while (!hasEnded) {
                if (flipFlop) {
                    System.out.println("Tick");
                }
                else {
                    System.out.println("Tock");
                }

                flipFlop = !flipFlop;

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex) { }
            }
        }

        public void stopMyTimer() {
            hasEnded = true;
        }
    }

    public static void startTickTocking() throws InterruptedException {
        TickTock timer = new TickTock();
        Thread timeThread = new Thread(timer);
        timeThread.start();

        Thread.sleep(10000);
        timer.stopMyTimer();
    }

    /*
     * ------------- Different means of interrupting a thread.sleep inside a thread -------------
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterrupt(); // method 1
        OtherThread tThread = new OtherThread();
        tThread.start();
        Thread.sleep(4000);
        tThread.interrupt();    // method 2
    }

    public static void ourInterrupt() {
        TestThread.runnable = false;
    }

    public static class TestThread implements Runnable {
        public static boolean runnable = true;

        public void run() {
            while (runnable) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);

                    // Get info from the thread in which this object was passed
                    Thread currentThread = Thread.currentThread();
                    String threadName = currentThread.getName();
                    boolean isThisInterrupted = currentThread.isInterrupted();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class OtherThread extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Ha-ha");
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex) {
                    System.out.println("Oh noes, you stopped me in my tracks!");
                }
            }
        }
    }

    /*
     * -------------------------- Different means of locking threads --------------------------
     */
    public static class Note {
        public final List<String> notes = new ArrayList<>();

        public void addNote(int index, String note) {
            System.out.println("A note [" + note + "] will now be added at position " + index);

            // The entire object instance of Note will be locked during the run cycle of the code in this block
            synchronized(this) {
                notes.add(index, note);
            }

            System.out.println("The note [" + note + "] has already been added");
        }

        public void removeNote(int index) {
            System.out.println("A note will now be deleted from position " + index);
            String note = "";

            // This will lock only the notes arraylist, not the output on screen or declaration of note (outside of the synchronized block)
            synchronized(notes) {
                note = notes.remove(index);
            }
            System.out.println("The note [" + note + "] has already been deleted from position " + index);
        }

        // This will lock the entire method (prints and arraylist manipulation)
        public synchronized void alterNote(int index, String note) {
            System.out.println("A note will now be altered at position " + index);
            notes.set(index, note);
            System.out.println("The note [" + note + "] has been altered");
        }
    }

    /*
     * -------------------------- Locking a singleton with a synchronized block inside a static block --------------------------
     */
    public static class OurPresident {
        private static OurPresident president;

        static {
            synchronized(OurPresident.class) {
                president = new OurPresident();
            }
        }

        private OurPresident() {
        }

        public static OurPresident getOurPresident() {
            return president;
        }
    }

    public static class IMF {
        private static IMF imf;
        // Introducing "volatile" - this keeps the program from caching the values in this variable.
        // Meaning: every thread can access this information in the main memory instead of having their own instance cached.
        // Also works as shared if there are child "thread" classes using this variable (eg IMFTellerThread, ...)
        public volatile ArrayList<Integer> sharedMoneyCache = new ArrayList<>();

        public static IMF getFund() {
            // Another example of a singleton synchronization
            synchronized(IMF.class) {
                if (imf == null) {
                    imf = new IMF();
                }
            }
            return imf;
        }

        private IMF() {
        }
    }
}
