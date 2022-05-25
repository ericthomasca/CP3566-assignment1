//Create a “Book” class which will represent the books from the “titles” table in the book's database.
// Each book object will have a list of its authors–a private attribute List<Author> authorList.
// (Make sure to populate the authorList attribute when loading the objects from the database.)

import java.util.List;

public class Book {

    private String ISBN;
    private String title;
    private int edition;
    private String copyright;
    private List<Author> authorList;

    public Book(String ISBN, String title, int edition, String copyright) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.copyright = copyright;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}

