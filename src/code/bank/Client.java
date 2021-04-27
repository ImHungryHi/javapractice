package code.bank;
import java.util.*;

public class Client {
    private List<Account> accounts = new ArrayList<>();
    private String name;

    public Client() {
        name = "Client " + SingletonIdentifier.getInstance().getIdentifier();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public String toString() {
        return name;
    }
}
