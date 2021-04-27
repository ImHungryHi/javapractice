package code.bank;

public class Account {
    private Client owner;
    private String name;

    public Account(Client owner) {
        this.owner = owner;
        this.owner.addAccount(this);
        name = "Account " + SingletonIdentifier.getInstance().getIdentifier();
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
        return name;
    }
}
