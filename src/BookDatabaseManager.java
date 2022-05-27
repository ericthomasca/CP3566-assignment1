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

import java.sql.*;
import java.util.List;
import java.util.Objects;

public class BookDatabaseManager {
    private final String DATABASE_URL = "jdbc:mariadb://localhost:3306/books";
    private final String USER = "root";
    private final String PASS = "Q5obBNgUy4";
    private List<Book> bookList;
    private List<Author> authorList;

    public BookDatabaseManager() {
    }

    public List<Book> getBookList() throws SQLException {
        ResultSet books = loadBooks();
        while (books.next()) {
            bookList.add(
                new Book(
                    books.getString("isbn"),
                    books.getString("title"),
                    books.getInt("editionNumber"),
                    books.getString("copyright")
                )
            );
        }
        return bookList;
    }

    public List<Author> getAuthorList() throws SQLException {
        ResultSet authors = loadAuthors();
        while (authors.next()) {
            authorList.add(
                new Author(
                    authors.getInt("authorID"),
                    authors.getString("firstName"),
                    authors.getString("lastName")
                )
            );
        }
        return authorList;
    }

    public void addNewBook(Book book) throws SQLException {
        Connection connection = loadDatabase();
        Statement statement = connection.createStatement();

        String ISBN = book.getISBN();
        String title = book.getTitle();
        int edition = book.getEdition();
        String copyright = book.getCopyright();

        String sqlQuery = "INSERT INTO titles (isbn, title, editionNumber, copyright) " +
                "VALUES (" + ISBN + ", " + title + ", " + edition + ", " + copyright + ");";
        statement.executeQuery(sqlQuery);
    }

    public void addNewAuthor(Author author) throws SQLException {
        Connection connection = loadDatabase();
        Statement statement = connection.createStatement();

        int authorID = author.getId();
        String firstName = author.getFirstName();
        String lastName = author.getLastName();

        String sqlQuery = "INSERT INTO authors (authorID, firstName, lastName) " +
                "VALUES (" + authorID + ", " + firstName + ", " + lastName + ");";

        statement.executeQuery(sqlQuery);
    }

    private Connection loadDatabase() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USER, PASS);
    }

    private ResultSet loadBooks() throws SQLException {
        Connection connection = loadDatabase();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * from titles";
        return statement.executeQuery(sqlQuery);
    }

    private ResultSet loadAuthors() throws SQLException {
        Connection connection = loadDatabase();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * from authors";
        return statement.executeQuery(sqlQuery);
    }
}
