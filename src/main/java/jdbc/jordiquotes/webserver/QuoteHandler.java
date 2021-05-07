package jdbc.jordiquotes.webserver;
import jdbc.jordiquotes.Config;
import jdbc.jordiquotes.daoimpl.QuoteDaoMySQL;
import jdbc.jordiquotes.model.Quote;
import com.github.ricksbrown.cowsay.Cowsay;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

public class QuoteHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Quote quote = new QuoteDaoMySQL().getRandomQuote();
        ArrayList<String> cows = Config.getCows();
        String cow = cows.get(new Random().nextInt(cows.size()));
        String[] cowArgs = new String[] { "--html", "-f", cow, quote.getAuthor() + " Says: " + quote.getQuote() };
        String response = "<html><head></head><body>" + Cowsay.say(cowArgs) + "</body></html>";
        exchange.sendResponseHeaders(200, response.length());

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
