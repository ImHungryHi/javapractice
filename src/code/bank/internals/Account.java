package code.bank.internals;

public class Account {
    private final String number;
    private final Currency currency;
    private Client owner;
    private double balance = 0d;

    Account(String number, Client owner, Currency currency) {
        this.number = number;
        this.owner = owner;
        this.owner.addAccount(this);
        this.currency = currency;
    }

    void withdraw(double amount) {
        this.balance -= amount;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    Currency getCurrency() {
        return currency;
    }

    double getCurrencyValue() {
        return currency.getValue();
    }

    String getNumber() {
        return number;
    }

    Client getOwner() {
        return owner;
    }

    void setOwner(Client newOwner) {
        this.owner = newOwner;
    }

    @Override
    public String toString() {
        return "Account { id => \'" + number + "\', " +
                "owner => \'" + owner.getAlias() + "\', " +
                "balance => " + balance + " " +
                "}";
    }
}
