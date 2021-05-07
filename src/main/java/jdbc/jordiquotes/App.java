package jdbc.jordiquotes;
import com.github.ricksbrown.cowsay.Cowsay;
import jdbc.jordiquotes.Config.*;
import jdbc.jordiquotes.dao.QuoteDao;
import jdbc.jordiquotes.daoimpl.QuoteDaoMySQL;
import jdbc.jordiquotes.model.Quote;
import org.jasypt.util.text.StrongTextEncryptor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //QuoteDaoMySQL quoteEngine = new QuoteDaoMySQL();
        //quoteEngine.debug();

        StrongTextEncryptor encryptor = new StrongTextEncryptor();
        encryptor.setPassword("feeduscroissants");
        String clearText = "code4croissants";
        String encrypted = encryptor.encrypt(clearText);
        String decrypted = encryptor.decrypt(encrypted);
        System.out.println(clearText + "\n" + encrypted+ "\n"+ decrypted);

        //generateCowQuote();
    }

    private static void generateCowQuote() {
        ArrayList<String> cows = Config.getCows();
        Random random = new Random();
        QuoteDao quoteEngine = new QuoteDaoMySQL();
        Quote quote = quoteEngine.getRandomQuote();
        String cow = cows.get(random.nextInt(cows.size()));
        String[] cowArgs = new String[]{"-f", cow, quote.getAuthor() + " Says: " + quote.getQuote()};
        String result = Cowsay.say(cowArgs);
        System.out.println(result);
        System.out.println("Do you like this one? (Y/N)");
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("y")) {
                quoteEngine.likeQuote(quote);
                System.out.println("What are we holding on to, Sam? - That there's some good in this world, Mr. Frodo. And it's worth fighting for.");
                break;
            }
            else if (input.equalsIgnoreCase("n")) {
                quoteEngine.dislikeQuote(quote);
                System.out.println("Don't blame you. *Starts counting 597 thousand million sheep*");
                break;
            }
            else {
                System.out.println("I only know how to respond to y or n...");
            }
        }
    }
}
