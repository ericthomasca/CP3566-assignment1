// Create an“Author” class which will represent the authors from the “authors” table
// in the books database. Each author object will have a list of the books they have
// written–a private attribute List<Book> bookList.(Make sure to populate the bookList
// attribute when loading the objects from the database.)
public class Author {
    private int authorID;
    private String firstName;
    private String lastName;

    public Author(int authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
