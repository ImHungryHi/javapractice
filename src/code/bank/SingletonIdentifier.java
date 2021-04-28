package code.bank;

import java.util.ArrayList;
import java.util.Random;

public class SingletonIdentifier {
    private static SingletonIdentifier instance;
    private int identifier;
    private ArrayList<String> uids = new ArrayList<>();

    private SingletonIdentifier() {
        identifier = 0;
    }

    public static SingletonIdentifier getInstance() {
        if (instance == null) {
            instance = new SingletonIdentifier();
        }

        return instance;
    }

    public String generateUid(int length) {
        StringBuilder output = new StringBuilder();
        Random r = new Random();

        for (int x = 0; x < length; x++) {
            output.append(r.nextInt(10));
        }

        return output.toString();
        /*StringBuilder output;
        Random r = new Random();

        do {
            output = new StringBuilder();

            for (int x = 0; x < length; x++) {
                output.append(r.nextInt(10));
            }
        } while (uids.contains(output.toString()));

        uids.add(output.toString());
        return output.toString();*/
    }

    public int getIdentifier() {
        return identifier++;
    }
}
