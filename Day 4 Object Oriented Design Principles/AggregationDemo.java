import java.util.ArrayList;
import java.util.List;

// Book class - Independent entity
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("Book Title: " + title + ", Author: " + author);
    }
}

// Library class - Aggregates Book objects
class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);  // Aggregation: Library "has-a" list of Books
    }

    public void displayLibraryBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.displayBookInfo();
        }
        System.out.println();
    }
}

// Main class to demonstrate aggregation
public class AggregationDemo {
    public static void main(String[] args) {
        // Create independent Book objects
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        // Create Library objects
        Library centralLibrary = new Library("Central Library");
        Library communityLibrary = new Library("Community Library");

        // Add books to libraries
        centralLibrary.addBook(b1);
        centralLibrary.addBook(b2);

        communityLibrary.addBook(b2);  // Shared book
        communityLibrary.addBook(b3);

        // Display library contents
        centralLibrary.displayLibraryBooks();
        communityLibrary.displayLibraryBooks();
    }
}













