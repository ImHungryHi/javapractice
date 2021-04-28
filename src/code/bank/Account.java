package code.bank;

public class Account {
    private Client owner;
    private String number;

    public Account(String number, Client owner) {
        this.number = number;
        this.owner = owner;
        this.owner.addAccount(this);
    }

    public void transfer(Client otherClient) {
        this.owner.removeAccount(this);
        this.owner = otherClient;
        this.owner.addAccount(this);
    }

    public Client getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account { id => \'" + number + "\', " +
                "owner => \'" + owner.getAlias() + "\' " +
                "}";
    }
}
