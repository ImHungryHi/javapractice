package code.bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client client = new Client();
        Account account = new Account(client);
        bank.accounts.add(account);
        bank.clients.add(client);
        System.out.println("Added " + account + " to " + account.getOwner());

        Client otherClient = new Client();
        account.transfer(otherClient);
        System.out.println("Transfered " + account + " to " + account.getOwner());
    }
}
