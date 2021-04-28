package code.bank;
import java.util.*;

public class Client {
    private HashMap<String, Account> accounts = new HashMap<>();
    private String uid;
    private String alias;

    public Client(String uid, String alias) {
        this.uid = uid;
        this.alias = alias;
    }

    public void addAccount(Account account) {
        accounts.put(account.getNumber(), account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account.getNumber());
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        StringBuilder myFormat = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, Account> account : accounts.entrySet()) {
            if (!first) {
                myFormat.append(", ");
            }
            else {
                first = false;
            }

            myFormat.append(account.getValue().toString());
        }

        return "Client { id => \'" + uid + "\', " +
                "alias => \'" + alias + "\', " +
                "accounts => [ " + myFormat + " ] " +
                "}";
    }
}
