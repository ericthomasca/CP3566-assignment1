import java.sql.*;

// Create a “BookDatabaseManager” class which will handle all database connections
// and queries as well as store lists of Books and Authors to be used by the main
// application. It is recommended that you do the following:
// •Stores the database URL and login as static private members. Note, any time
//  you use a database connection ensure that you close the connection when
//  finished –don’t allow connections to persist.
// •Create a private loadDatabase method that coordinates the queries for both
//  the books and authors and their relationships. Note: you can use other
//  private methods to simplify the code. (Open and close the database connection
//  within this method.)
//    •To simplify this method, you may want to create two additional methods
//    (e.g. loadBooks and loadAuthors).
// •Create an addNewBook method and addNewAuthor method that inserts a book or
//  author into the database from user input form the terminal.Use a prepared
//  statement to handle the new book and new author creation.
//
// NOTE: We will not be concerned with any update queries. To simply the
// solution it is assumed that any entered authors or books are legitimate
// (e.g. we don’t care if two authors have the same name).
public class BookDatabaseManager {
    static final String DB_URL = "jdbc:mariadb://localhost:3306/books";
    static final String USER = "root";
    static final String PASS = "Q5obBNgUy4";
    static final String QUERY = "SELECT authorID, firstName, lastName FROM authors";

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
