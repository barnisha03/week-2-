import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println(name + " - $" + price);
    }
}

class Order {
    int orderId;
    List<Product> products = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showOrder() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) p.display();
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Order o) {
        orders.add(o);
    }

    public void viewOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) o.showOrder();
    }
}

public class EcommerceApp {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 800);
        Product p2 = new Product("Mouse", 20);

        Order o1 = new Order(101);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Customer c1 = new Customer("Alice");
        c1.placeOrder(o1);

        c1.viewOrders();
    }
}



















