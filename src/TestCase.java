public class TestCase {
    public static void nestedLoops() {
        int x = 0, y = 0;
        System.out.println("----------------------------------------------");

        while (x++ < 10) {
            while (y++ < 10) System.out.printf("%4d", x * y);

            System.out.println();
            y = 0;
        }

        System.out.println("----------------------------------------------");

        for (x = 0; x++ < 10;) {
            for (y = 0; y++ < 10;)
                    System.out.printf("%4d", x * y);

            System.out.println();
        }

        System.out.println("----------------------------------------------");
    }

    public static void whileLoops() {
        int x = 0;

        // LOOP 10 TIMES FROM 0-9
        while (x < 10) {
            System.out.printf("%3d", x);
            x++;
        }

        x = 0;
        System.out.println();

        // LOOP 10 TIMES FROM 0-9, PRINT 1-10
        while (x++ < 10) System.out.printf("%3d", x);

        x = 0;
        System.out.println();

        // LOOP 9 TIMES FROM 1-9, PRINT 1-9
        while (++x < 10) System.out.printf("%3d", x);

        x = 0;
        System.out.println();

        // LOOP 10 TIMES FROM 0-9, PRINT 1-10
        while (10 > x++) System.out.printf("%3d", x);

        x = 0;
        System.out.println();

        // LOOP 9 TIMES FROM 1-9, PRINT 1-9
        while (10 > ++x) System.out.printf("%3d", x);
        System.out.println();
    }

    public static void forLoops() {
        for (int x = 1; x <= 10; x++) System.out.printf("%3d", x);
        System.out.println();

        // For all 4 of the below situations, the index STARTS 1 index later than the initialization
        // For these, you'll have to lower the threshold as x is incremented 1 index beyond
        for (int x = 0; 9 >= x++;) System.out.printf("%3d", x);
        System.out.println();
        for (int x = 0; x++ <= 9;) System.out.printf("%3d", x);
        System.out.println();

        // These 2 will have 1 less loop
        for (int x = 0; 10 >= ++x;) System.out.printf("%3d", x);
        System.out.println();
        for (int x = 0; ++x <= 10;) System.out.printf("%3d", x);
        System.out.println();
    }

    public static void demoOperands() {
        int a = 20, b = 20;

        System.out.println("------ ; " + a + " ; " + b + " ; START LOGICAL ------");

        // BOTH STATEMENTS WILL BE EXECUTED AND COMPARED
        if (a++ >= 20 && b++ >= 20) System.out.println(a + " ; " + b + " ; AND, both true");

        a = 20;
        b = 20;

        // ONLY THE FIRST STATEMENT WILL BE EXECUTED BECAUSE OF A SHORT CIRCUIT
        if (a++ < 20 && b++ < 20) System.out.println(a + " ; " + b + " ; AND, both false");
        else System.out.println(a + " ; " + b + " ; AND, both false - else");

        a = 20;
        b = 20;

        // ONLY THE FIRST STATEMENT WILL BE EXECUTED BECAUSE OF A SHORT CIRCUIT
        if (a++ >= 20 || b++ >= 20) System.out.println(a + " ; " + b + " ; OR, both true");

        a = 20;
        b = 20;

        // BOTH STATEMENTS WILL BE EXECUTED AND COMPARED
        if (a++ < 20 || b++ < 20) System.out.println(a + " ; " + b + " ; OR, both false");
        else System.out.println(a + " ; " + b + " ; OR, both false - else");

        a = 20;
        b = 20;
        // ---- IN ALL BITWISE CASES, BOTH STATEMENTS WILL BE EXECUTED AND COMPARED ---- //
        System.out.println("------ ; " + a + " ; " + b + " ; START BITWISE ------");
        if (a++ >= 20 & b++ >= 20) System.out.println(a + " ; " + b + " ; AND, both true");

        a = 20;
        b = 20;
        if (a++ < 20 & b++ < 20) System.out.println(a + " ; " + b + " ; AND, both false");
        else System.out.println(a + " ; " + b + " ; AND, both false - else");

        a = 20;
        b = 20;
        if (a++ >= 20 | b++ >= 20) System.out.println(a + " ; " + b + " ; OR, both true");

        a = 20;
        b = 20;
        if (a++ < 20 | b++ < 20) System.out.println(a + " ; " + b + " ; OR, both false");
        else System.out.println(a + " ; " + b + " ; OR, both false - else");
    }

    public static void timing() {
        try {
            System.out.println(Experiment.getIntervalTime());
            Experiment.startTimer();
            // println will add time to your total processing time
            System.out.println(Experiment.getIntervalTime());
            Thread.sleep(100);
            System.out.println(Experiment.getIntervalTime());
            System.out.println(Experiment.endTimer());
        }
        catch (Exception ex) {
            // Thread.sleep won't allow for uncaught exceptions, even if no exception will occur
        }
    }

    public static void tafelVanTien() {
        for (int x = 1; x <= 10; x++) {
            //for (int y = 1; 10 >= y++;)
            for (int y = 1; y <= 10; y++)
                System.out.printf("%4d", x * y);    // right align with 4 digits (fill with spaces)
            //System.out.printf("%d\t", x * y); // left align with tabs

            System.out.println();
        }
    }
}
