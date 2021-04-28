package code.bank;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client mrFreeman = bank.addClient("Mr Freeman");
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
