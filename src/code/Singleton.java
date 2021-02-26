package code;

/*
 * -----------------------------------------------------------------------------------------
 * ------------ Protect your properties and avoid external instantiation (final) -----------
 * -----------------------------------------------------------------------------------------
 */
public final class Singleton {
    private static Singleton instance;

    // Makes it so that an external class can't reach the constructor publicly
    private Singleton() {}

    // External classes can get an instance of the code.Singleton class by calling code.Singleton.getInstance()
    public static Singleton getInstance() {
        return instance;
    }
}