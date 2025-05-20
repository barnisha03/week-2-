class Product {
    private static double discount = 10.0; // 10% default discount

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;  // final
        this.productName = productName; // this
        this.price = price;
        this.quantity = quantity;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop", 1200, 2);
        Product p2 = new Product(2, "Smartphone", 800, 3);

        p1.displayProductDetails();
        p2.displayProductDetails();

        Product.updateDiscount(15);
        p1.displayProductDetails();
    }
}











