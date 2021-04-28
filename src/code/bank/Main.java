package code.bank;
import code.bank.internals.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Before adding classes to internals package
        Client mrFreeman = bank.addClient("Mr Freeman");
        Account freeman1 = bank.addAccount(mrFreeman, Currency.EURO);
        Account freeman2 = bank.addAccount(mrFreeman, Currency.CARDANO);

        System.out.println(mrFreeman);

        Client agentSmith = bank.addClient("Agent Smith");
        bank.transferAccount(freeman1, agentSmith);

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
