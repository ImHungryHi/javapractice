package code;

/*
 * -----------------------------------------------------------------------------------------
 * ------------ Protect your properties and avoid external instantiation (final) -----------
 * -----------------------------------------------------------------------------------------
 */
public final class Singleton {
    private static Singleton instance;
    private int index;

    // Makes it so that an external class can't reach the constructor publicly
    private Singleton() {}

    // External classes can get an instance of the code.Singleton class by calling code.Singleton.getInstance()
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    // This is not a constructor, it just looks like one, CAN'T be called with "new Singleton()"
    public static Singleton Singleton() {
        // Same thing, different name
        return getInstance();
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

/*
 * -----------------------------------------------------------------------------------------
 * ------------------------------------- Why use this? -------------------------------------
 * -----------------------------------------------------------------------------------------
 * -> a Singleton can make functions for a multi-class instance; eg the following code will use the same instance
 */

/*
    public class ClassA {
        private Singleton instance;

        public ClassA() {
            instance = Singleton.getInstance();
            instance.setIndex = 0;
        }
    }

    public class ClassB {
        private Singleton instance;

        public ClassB() {
            instance = Singleton.getInstance();
            instance.setIndex = 10;
        }
    }

    public class MyRuntime {
        public static void main(String[] args) {
            ClassA aObj = new ClassA();
            // aObj.instance == 0
            ClassB bObj = new ClassB();
            // aObj.instance == 10
            // bObj.instance == 10
            aObj = new ClassA();
            // aObj.instance == 0
            // bObj.instance == 0
        }
    }
 */
