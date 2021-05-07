package jdbc.jordiquotes;
import jdbc.jordiquotes.webserver.*;
import com.sun.net.httpserver.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebApp {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        // Backlog (int value in create) is the amount of requests that can be backed up for retries
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        System.out.println("Starting...");
        server.createContext("/", new RootHandler());
        server.createContext("/test", new TestHandler());
        server.createContext("/quote", new QuoteHandler());

        // Multi-threading here, just be careful for DDOS attacks which flood the memory
        ExecutorService executor = Executors.newCachedThreadPool(); // Makes and reuses threads as needed
        //ExecutorService executor = Executors.newFixedThreadPool(5);   // Limits threads to a total of 5 - a little more secure
        server.setExecutor(executor);

        //server.setExecutor(null);
        server.start();
        System.out.println("Server started on port " + PORT);
    }
}
