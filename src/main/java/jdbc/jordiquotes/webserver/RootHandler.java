package jdbc.jordiquotes.webserver;
import com.sun.net.httpserver.*;
import java.io.IOException;
import java.io.OutputStream;

public class RootHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "<h1>Hello darkness, my old friend</h1>";
        exchange.sendResponseHeaders(200, response.length());

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();

        // Extra knowledge
        String pathAndParameters = exchange.getRequestURI().toString(); // eg: localhost:5000/?parm1=val => "/?parm1=val"
    }
}
