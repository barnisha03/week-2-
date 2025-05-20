class Book {
    private static String libraryName = "City Library";

    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title; // using this to initialize
        this.author = author;
        this.isbn = isbn;
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
            System.out.println("Library: " + libraryName);
        }
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", "ISBN123");
        book1.displayBookDetails();
        Book.displayLibraryName();
    }
}










