//Create a “Book” class which will represent the books from the “titles” table in the books database.
// Each book object will have a list of its authors–a private attribute List<Author> authorList.
// (Make sure to populate the authorList attribute when loading the objects from the database.)

public class Book {

    private String isbn;
    private String title;
    private int editionNumber;
    private int copyright;
//    private List<Author> authorList;

    public Book(String isbn, String title, int editionNumber, int copyright) {
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyright = copyright;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public int getCopyright() {
        return copyright;
    }

}
