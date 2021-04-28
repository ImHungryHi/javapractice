package code.bank.internals;

public class Account {
    private Client owner;
    private String number;
    private Currency currency;

    Account(String number, Client owner, Currency currency) {
        this.number = number;
        this.owner = owner;
        this.owner.addAccount(this);
        this.currency = currency;
    }

    void transfer(Client otherClient) {
        this.owner.removeAccount(this);
        this.owner = otherClient;
        this.owner.addAccount(this);
    }

    Client getOwner() {
        return owner;
    }

    String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Account { id => \'" + number + "\', " +
                "owner => \'" + owner.getAlias() + "\' " +
                "}";
    }
}
