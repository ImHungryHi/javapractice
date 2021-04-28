package code.bank;
import java.util.*;

public class Client {
    private List<Account> accounts = new ArrayList<>();
    private String uid;
    private String alias;

    public Client(String uid, String alias) {
        this.uid = uid;
        this.alias = alias;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return "Client { id => \'" + uid + "\', " +
                "alias => \'" + alias + "\', " +
                "accounts => " + accounts.toString() + " " +
                "}";
    }
}
