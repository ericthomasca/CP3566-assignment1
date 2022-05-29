/*
    1. Create a Java class called “BookApplication” with a main method that
  prompts the user to select any of the following options:
      1. Print all the books from the database (showing the authors)
      2. Print all the authors from the database (showing the books)
      3. Add a book to the database for an existing author
      4. Add a new author
      5. Quit2.Note that the user should be able to
         continue making choices until they quit.
      5. Quit
    2. Note that the user should be able to continue making choices until
       they quit.
 */

import java.sql.*;
import java.util.Arrays;

public class BookApplication {
    public static void main(String[] args) throws SQLException {
        BookDatabaseManager bookDbManager = new BookDatabaseManager();
        Connection connection = bookDbManager.loadDatabase();
        // Print all the books from the database (showing the authors)
        ResultSet books = bookDbManager.loadBooks();
        while (books.next()) {
            System.out.printf("%s\t\t%s\t\t%d\t\t%s\n",
                    books.getString("isbn"),
                    books.getString("title"),
                    books.getInt("editionNumber"),
                    books.getString("copyright"));
        }

        // Print all the authors from the database (showing the books)
        ResultSet authors = bookDbManager.loadAuthors();
        while (authors.next()) {
            System.out.printf("%s \t\t\t %s\n",
                    authors.getString("firstName"),
                    authors.getString("lastName"));
        }

        // Add a book to the database for an existing author
        Book newBook = new Book(
                "0132873625",
                "Go Fun Yourself: A Guide to Functions in the Go Programming Language",
                1,
                "2022"
        );
        bookDbManager.addNewBook(newBook);

        // Add a new author
        Author newAuthor = new Author(
                6,
                "Book",
                "Writer"
        );
        bookDbManager.addNewAuthor(newAuthor);
    }
}
