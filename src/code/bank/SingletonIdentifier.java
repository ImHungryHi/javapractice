package code.bank;

public class SingletonIdentifier {
    private static SingletonIdentifier instance;
    private int identifier;

    private SingletonIdentifier() {
        identifier = 0;
    }

    public static SingletonIdentifier getInstance() {
        if (instance == null) {
            instance = new SingletonIdentifier();
        }

        return instance;
    }

    public int getIdentifier() {
        return identifier++;
    }
}
