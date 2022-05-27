/*
    1. Create a Java class called “BookApplication” with a main method that
  prompts the user to select any of the following options:
      1. Print all the books from the database (showing the authors)
      2. Print all the authors from the database (showing the books)
      3. Add a book to the database for an existing author
      4. Add a new author5.Quit2.Note that the user should be able to
         continue making choices until they quit.
      5. Quit
    2. Note that the user should be able to continue making choices until
       they quit.
 */

public class BookApplication {
    public static void main(String[] args) {
        BookDatabaseManager bookDbManager = new BookDatabaseManager();
    }
}
