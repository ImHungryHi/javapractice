package jdbc.jordiquotes.daoimpl;
import jdbc.jordiquotes.dao.QuoteDao;
import jdbc.jordiquotes.model.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class QuoteDaoImpl implements QuoteDao {
    private String url = "jdbc:mysql://ID109462_crud.db.webhosting.be:3306/ID109462_crud";
    private String user = "ID109462_crud";
    private String passwd = "code4croissants";

    @Override
    public Quote getRandomQuote() {
        Random random = new Random();
        String query = "SELECT * FROM jordiquotes";
        ArrayList<Quote> quotes = getQuotes(query);
        Quote randomQuote = quotes.get(random.nextInt(quotes.size()));
        int id, likes, dislikes;
        String author, quote;

        return randomQuote;
    }

    private ArrayList<Quote> getQuotes(String query) {
        ArrayList<Quote> quotes = new ArrayList<>();
        int id, likes, dislikes;
        String author, quote;

        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet result = stmt.executeQuery()) {
                    while (result.next()) {
                        id = result.getInt("ID");
                        author = result.getString("author");
                        quote = result.getString("quote");
                        likes = result.getInt("likes");
                        dislikes = result.getInt("dislikes");
                        quotes.add(new Quote(id, author, quote, likes, dislikes));
                    }
                }
                catch (SQLException ex) {
                    // Do some debug dumps
                }
            }
            catch (SQLException ex) {
                // Do some debug dumps
            }
        }
        catch (SQLException ex) {
            // Do some debug dumps
        }

        return quotes;
    }

    @Override
    public void likeQuote(Quote quote) {
        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE jordiquotes SET likes = ? WHERE ID = ?")) {
                stmt.setInt(1, quote.getLikes() + 1);
                stmt.setInt(2, quote.getId());

                int updated = stmt.executeUpdate();
            }
            catch (SQLException ex) {
                // Do some debug dumps
            }
        }
        catch (SQLException ex) {
            // Do some debug dumps
        }
    }

    @Override
    public void dislikeQuote(Quote quote) {
        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement("UPDATE jordiquotes SET dislikes = ? WHERE ID = ?")) {
                stmt.setInt(1, quote.getDislikes() + 1);
                stmt.setInt(2, quote.getId());

                int updated = stmt.executeUpdate();
            }
            catch (SQLException ex) {
                // Do some debug dumps
            }
        }
        catch (SQLException ex) {
            // Do some debug dumps
        }
    }
}
