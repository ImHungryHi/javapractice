package code.bank.internals;

import java.util.*;

public class Bank {
    /*List<Client> clients = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();*/
    private final HashMap<String, Account> accounts = new HashMap<>();
    private final HashMap<String, Client> clients = new HashMap<>();
    private final int UID_LENGTH = 9;

    public Client addClient(String alias) {
        String uid;

        do {
            uid = SingletonIdentifier.getInstance().generateUid(UID_LENGTH);
        } while (clients.containsKey(uid));

        Client client = new Client(uid, alias);
        clients.put(uid, client);
        return client;
    }

    public Account addAccount(Client owner, Currency currency) {
        String uid;

        do {
            uid = SingletonIdentifier.getInstance().generateUid(UID_LENGTH);
        } while (accounts.containsKey(uid));

        Account account = new Account(uid, owner, currency);
        accounts.put(uid, account);
        return account;
    }

    public void transferAccount(Account account, Client newOwner) {
        Client owner = account.getOwner();
        account.setOwner(newOwner);
        owner.removeAccount(account);
        newOwner.addAccount(account);
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    public void transferCurrency(double amount, Account from, Account to) {
        double fromCurrency = from.getCurrencyValue();
        double toCurrency = to.getCurrencyValue();
        from.withdraw(amount);

        amount = (amount / fromCurrency) * toCurrency;
        to.deposit(amount);
    }
}
