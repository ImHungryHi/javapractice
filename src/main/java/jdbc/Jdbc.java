package jdbc;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://ID109462_crud.db.webhosting.be:3306/ID109462_crud",
                user = "ID109462_crud",
                passwd = "code4croissants",
                query = "SELECT * FROM jordiquotes";

        Connection conn = DriverManager.getConnection(url, user, passwd);
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            // Column name should be given
            System.out.println(result.getString("author") + " said \"" + result.getString("quote") + "\"");
        }

        // In a try-catch statement, these would be executed on a fail if you put a try with resources
        result.close();
        stmt.close();
        conn.close();

    }
}
