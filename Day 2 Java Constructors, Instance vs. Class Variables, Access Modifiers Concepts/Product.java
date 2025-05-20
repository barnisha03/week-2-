public class Product {
    private String productName;
    private double price;
    
    private static int totalProducts = 0; // Class variable shared by all products
    
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment whenever a new product is created
    }
    
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }
    
    public static void displayTotalProducts() {
        System.out.println("Total products created: " + totalProducts);
    }
    
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200.50);
        Product p2 = new Product("Smartphone", 800.00);
        
        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        
        Product.displayTotalProducts();
    }
}






