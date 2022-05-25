import java.util.List;

// Create an“Author” class which will represent the authors from the “authors” table
// in the book's database. Each author object will have a list of the books they have
// written–a private attribute List<Book> bookList.(Make sure to populate the bookList
// attribute when loading the objects from the database.)

/**
 * A book author
 */
public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private List<Book> bookList;

    /**
     * A book author
     * @param id author id
     * @param firstName author's first name
     * @param lastName author's last name
     */
    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns author id
     * @return author id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets author id
     * @param id author id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns author's first name
     * @return author's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets author's first name
     * @param firstName author's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns author's last name
     * @return author's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets authors last name
     * @param lastName author's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns list of books from the author
     * @return list of books from the author
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Sets the list of books from the author
     * @param bookList list of books from the author
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}




