package jdbc.jordiquotes;
import com.github.ricksbrown.cowsay.Cowsay;
import jdbc.jordiquotes.dao.QuoteDao;
import jdbc.jordiquotes.daoimpl.QuoteDaoMySQL;
import jdbc.jordiquotes.model.Quote;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        QuoteDaoMySQL quoteEngine = new QuoteDaoMySQL();
        quoteEngine.debug();

        //generateCowQuote();
    }

    private static void generateCowQuote() {
        ArrayList<String> cows = getCows();
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

    private static ArrayList<String> getCows() {
        return new ArrayList<>() {{
                    add("beavis");
                    add("bong");
                    add("bud-frogs");
                    add("bunny");
                    add("cheese");
                    add("cower");
                    add("daemon");
                    add("default");
                    add("dragon-and-cow");
                    add("dragon");
                    add("elephant-in-snake");
                    add("eyes");
                    add("flaming-sheep");
                    add("ghostbusters");
                    add("head-in");
                    add("hellokitty");
                    add("kiss");
                    add("kitty");
                    add("koala");
                    add("kosh");
                    add("luke-koala");
                    add("mech-and-cow");
                    add("meow");
                    add("milk");
                    add("moofasa");
                    add("moose");
                    add("mutilated");
                    add("ren");
                    add("satanic");
                    add("sheep");
                    add("skeleton");
                    add("small");
                    add("sodomized");
                    add("squirrel");
                    add("stegosaurus");
                    add("stimpy");
                    add("supermilker");
                    add("surgery");
                    add("telebears");
                    add("three-eyes");
                    add("turkey");
                    add("turtle");
                    add("tux");
                    add("udder");
                    add("vader-koala");
                    add("vader");
                    add("www");
                }};
    }
}
