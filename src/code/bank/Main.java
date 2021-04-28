package code.bank;
import code.bank.internals.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Before adding classes to internals package
        Client mrFreeman = bank.addClient("Mr Freeman");
        Account freeman1 = bank.addAccount(mrFreeman, Currency.EURO);
        Account freeman2 = bank.addAccount(mrFreeman, Currency.CARDANO);
        bank.deposit(freeman1, 500d);
        bank.deposit(freeman2, 200d);

        System.out.println(mrFreeman);
        System.out.println("--- Wiring money from Mr Freeman to Agent Smith ---");

        Client agentSmith = bank.addClient("Agent Smith");
        bank.transferAccount(freeman1, agentSmith);
        bank.transferMoney(100d, freeman1, freeman2);

        System.out.println(mrFreeman);
        System.out.println(agentSmith);
        System.out.println("--- Wiring money from Agent Smith to Mr Freeman ---");

        bank.transferMoney(100d, freeman2, freeman1);
        System.out.println(mrFreeman);
        System.out.println(agentSmith);

        // Before optimizations
        /*Client client = new Client();
        Account account = new Account(client);
        bank.accounts.add(account);
        bank.clients.add(client);
        System.out.println("Added " + account + " to " + account.getOwner());

        Client otherClient = new Client();
        account.transfer(otherClient);
        System.out.println("Transfered " + account + " to " + account.getOwner());*/
        /*SingletonIdentifier instance = SingletonIdentifier.getInstance();

        ArrayList<String> nums = new ArrayList<>() {{
            add(instance.generateUid(9));
            add(instance.generateUid(9));
            add(instance.generateUid(9));
            add(instance.generateUid(9));
            add(instance.generateUid(9));
            add(instance.generateUid(9));
        }};

        for (String s : nums) {
            System.out.println(s);
        }*/
    }
}
