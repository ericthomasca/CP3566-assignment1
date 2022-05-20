import java.sql.*;
import java.util.List;

public class Book {
    static final String DB_URL = "jdbc:mariadb://localhost:3306/books";
    static final String USER = "root";
    static final String PASS = "Batman0928";
    static final String QUERY = "SELECT authorID, firstName, lastName FROM authors";
    private List<Author> authorList;

    public static void main(String[] args) {

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("Author ID: " + rs.getInt("authorID"));
                System.out.print(", First Name: " + rs.getString("firstName"));
                System.out.println(", Last Name: " + rs.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
