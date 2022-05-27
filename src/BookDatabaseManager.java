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

    public List<Book> getBookList() {
        try (ResultSet books = loadBooks()) {
            while (books != null && books.next()) {
                bookList.add(
                        new Book(
                                books.getString("isbn"),
                                books.getString("title"),
                                books.getInt("editionNumber"),
                                books.getString("copyright")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public List<Author> getAuthorList() {
        try (ResultSet authors = loadAuthors()) {
            while (authors != null && authors.next()) {
                authorList.add(
                        new Author(
                                authors.getInt("authorID"),
                                authors.getString("firstName"),
                                authors.getString("lastName")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public void addNewBook(Book book) {
        try (
                Connection connection = loadDatabase();
                Statement statement = connection != null ? connection.createStatement() : null) {

            String ISBN = book.getISBN();
            String title = book.getTitle();
            int edition = book.getEdition();
            String copyright = book.getCopyright();

            String sqlQuery = "INSERT INTO titles (isbn, title, editionNumber, copyright) VALUES (" + ISBN + ", " + title + ", " + edition + ", "  + copyright + ");";

            Objects.requireNonNull(statement).executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewAuthor(Author author) {
        try (
                Connection connection = loadDatabase();
                Statement statement = connection != null ? connection.createStatement() : null) {

            int authorID = author.getId();
            String firstName = author.getFirstName();
            String lastName = author.getLastName();

            String sqlQuery = "INSERT INTO authors (authorID, firstName, lastName) VALUES (" + authorID + ", " + firstName + ", " + lastName + ");";

            Objects.requireNonNull(statement).executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Connection loadDatabase() {
        try {
            return DriverManager.getConnection(DATABASE_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet loadBooks() {
        try (
                Connection connection = loadDatabase();
                Statement statement = connection != null ? connection.createStatement() : null) {

            String sqlQuery = "SELECT * from titles";
            return statement != null ? statement.executeQuery(sqlQuery) : null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResultSet loadAuthors() {
        try (
                Connection connection = loadDatabase();
                Statement statement = connection != null ? connection.createStatement() : null) {

            String sqlQuery = "SELECT * from authors";
            return statement != null ? statement.executeQuery(sqlQuery) : null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

