class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter and Setter for private author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

// Subclass demonstrating access to ISBN and title
class EBook extends Book {

    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayDetails() {
        System.out.println("ISBN (public): " + ISBN);
        System.out.println("Title (protected): " + title);
        // Can't access author directly because it's private
        System.out.println("Author (via getter): " + getAuthor());
    }
}

public class BookLibraryTest {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-0134685991", "Effective Java", "Joshua Bloch");
        ebook.displayDetails();

        ebook.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}









