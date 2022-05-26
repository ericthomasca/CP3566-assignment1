//Create a “Book” class which will represent the books from the “titles” table in the book's database.
// Each book object will have a list of its authors–a private attribute List<Author> authorList.
// (Make sure to populate the authorList attribute when loading the objects from the database.)

import java.util.List;

/**
 * A book
 *
 * @author Eric Thomas
 */
public class Book {
    private String ISBN;
    private String title;
    private int edition;
    private String copyright;
    private List<Author> authorList;

    /**
     * A book
     * @param ISBN ISBN
     * @param title book title
     * @param edition book edition
     * @param copyright book copyright
     */
    public Book(String ISBN, String title, int edition, String copyright) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.copyright = copyright;
    }

    /**
     * Returns ISBN
     *
     * @return ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Set ISBN
     *
     * @param ISBN ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Returns title of book
     *
     * @return book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set book title
     *
     * @param title book title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns book edition
     *
     * @return book edition
     */
    public int getEdition() {
        return edition;
    }

    /**
     * Set book edition
     *
     * @param edition book edition
     */
    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     * Returns copyright
     *
     * @return copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Set copyright
     *
     * @param copyright copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * Returns list of authors
     *
     * @return list of authors
     */
    public List<Author> getAuthorList() {
        return authorList;
    }

    /**
     * Sets list of authors
     *
     * @param authorList list of authors
     */
    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}

