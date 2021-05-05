package jdbc;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://ID109462_crud.db.webhosting.be:3306/ID109462_crud",
                user = "ID109462_crud",
                passwd = "code4croissants",
                query = "SELECT * FROM jordiquotes";
        //select(url, user, passwd, query);

        query = "INSERT INTO jordiquotes(author, quote) VALUES(?, ?)";
        //String[] params = { "Chris", "Unix is user friendly. It's just very particular about who its friends are." };
        String[] params = { "Marvin", "Life? Don't talk to me about life. Here I am, brain the size of a planet, and they tell me to take you up to the bridge. Call that job satisfaction? 'Cos I don't." };
        //insert(url, user, passwd, query, params);

        query = "UPDATE jordiquotes SET quote = ? WHERE ID = ?";
        //update(url, user, passwd, query, "Unix is simple. It just takes a genius to understand its simplicity.", 200);

        query = "DELETE FROM jordiquotes WHERE ID = ?";
        //update(url, user, passwd, query, 300);

        query = "SELECT * FROM jordiquotes";
        select(url, user, passwd, query);
    }

    public static void select(String url, String user, String passwd, String query) {
        // Use this type of structure if there are multiple pieces of code within each level of try-blocks
        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet result = stmt.executeQuery()) {
                    while (result.next()) {
                        // Column name should be given
                        System.out.println(result.getString("ID") + " : " + result.getString("author") + " said \"" + result.getString("quote") + "\"");
                    }

                    // In a try-catch statement, these would be executed on a fail if you put a try with resources
                    /*result.close();
                    stmt.close();
                    conn.close();*/
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
    }

    public static void insert(String url, String user, String passwd, String query, String[] params) {
        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                for (int x = 0; x < params.length; x++) {
                    stmt.setString(x + 1, params[x]);
                }

                int inserted = stmt.executeUpdate();

                try (ResultSet results = stmt.getGeneratedKeys()) {
                    if (results.next()) {
                        System.out.println("Inserted row = " + results.getInt(1));
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
    }

    public static void update(String url, String user, String passwd, String query, String newQuote, int rowId) {
        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, newQuote);
                stmt.setInt(2, rowId);

                int updated = stmt.executeUpdate();
                System.out.println("Updated number of rows = " + updated);
            }
            catch (SQLException ex) {
                // Do some debug dumps
            }
        }
        catch (SQLException ex) {
            // Do some debug dumps
        }
    }

    public static void delete(String url, String user, String passwd, String query, int rowId) {
        try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, rowId);

                int deleted = stmt.executeUpdate();
                System.out.println("Deleted number of rows = " + deleted);
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
