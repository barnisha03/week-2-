// Abstract Class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName; // Sensitive info (encapsulation)

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public void setBorrowerName(String name) {
        this.borrowerName = name;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    public abstract int getLoanDuration(); // Abstract method
}

// Interface
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Subclass: Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved successfully.");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine reserved successfully.");
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved successfully.");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "Java Programming", "James Gosling"),
            new Magazine("M001", "Tech Monthly", "Editorial Team"),
            new DVD("D001", "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                reservableItem.reserveItem();
                System.out.println("Availability: " + (reservableItem.checkAvailability() ? "Available" : "Not Available"));
            }

            System.out.println();
        }
    }
}


