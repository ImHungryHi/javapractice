package jdbc.jordiquotes;
import com.github.ricksbrown.cowsay.Cowsay;
import jdbc.jordiquotes.dao.QuoteDao;
import jdbc.jordiquotes.daoimpl.QuoteDaoMySQL;
import jdbc.jordiquotes.model.Quote;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        ArrayList<String> cows = getCows();
        Random random = new Random();
        QuoteDao quoteEngine = new QuoteDaoMySQL();
        Quote quote = quoteEngine.getRandomQuote();
        String cow = cows.get(random.nextInt(cows.size()));
        String[] cowArgs = new String[]{"-f", cow, quote.getAuthor() + " Says: " + quote.getQuote()};
        String result = Cowsay.say(cowArgs);
        System.out.println(result);
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
