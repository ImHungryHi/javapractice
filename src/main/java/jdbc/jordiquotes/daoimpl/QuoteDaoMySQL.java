package jdbc.jordiquotes.daoimpl;
import jdbc.jordiquotes.dao.QuoteDao;
import jdbc.jordiquotes.model.Quote;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class QuoteDaoMySQL implements QuoteDao {
    private static final String url;
    private static final String user;
    private static final String passwd;

    static {
        String tUrl = "", tUser = "", tPasswd = "";
        // This bit with getResourceAsStream only works with maven resources! Otherwise, use FileInputStream and proper paths...
        try (InputStream inStream = QuoteDaoMySQL.class.getResourceAsStream("/jordiquotes.properties")) {
            Properties props = new Properties();
            props.load(inStream);
            tUrl = props.getProperty("url");
            tUser = props.getProperty("user");
            tPasswd = props.getProperty("passwd");
        } catch (IOException e) {
            // Nope, Chuck Testa!
        }
        url = tUrl;
        user = tUser;
        passwd = tPasswd;
    }

    @Override
    public Quote getRandomQuote() {
        /*Random random = new Random();
        String query = "SELECT * FROM jordiquotes";
        ArrayList<Quote> quotes = getQuotes(query);
        Quote randomQuote = quotes.get(random.nextInt(quotes.size()));*/
        String query = "SELECT * FROM jordiquotes ORDER BY RAND() LIMIT 1";
        Quote randomQuote = null;

        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet result = stmt.executeQuery()) {
                    if (result.next()) {
                        int id = result.getInt("ID");
                        String author = result.getString("author");
                        String quote = result.getString("quote");
                        int likes = result.getInt("likes");
                        int dislikes = result.getInt("dislikes");
                        randomQuote = new Quote(id, author, quote, likes, dislikes);
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

        return randomQuote;
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

    public void debug() {
        String query = "SELECT * FROM jordiquotes";
        ArrayList<Quote> quotes = getQuotes(query);

        for (Quote quote : quotes) {
            System.out.println(quote.getId() + " : " + quote.getAuthor() + " said \"" + quote.getQuote() + "\" [" + quote.getLikes() + ":" + quote.getDislikes() + "]");
        }
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
}
