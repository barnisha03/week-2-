// Abstract class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }

    // Abstract method
    public abstract double calculateTotalPrice();
}

// Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charge
    }

    @Override
    public double applyDiscount() {
        return 0.1 * calculateTotalPrice(); // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg item.";
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + 20) * getQuantity(); // Rs.20 extra per item
    }

    @Override
    public double applyDiscount() {
        return 0.05 * calculateTotalPrice(); // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg item.";
    }
}

// Main class to demonstrate polymorphism
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] orderItems = {
            new VegItem("Paneer Butter Masala", 150, 2),
            new NonVegItem("Chicken Biryani", 200, 3)
        };

        for (FoodItem item : orderItems) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                double discount = d.applyDiscount();
                System.out.println(d.getDiscountDetails());
                System.out.println("Total after discount: " + (total - discount));
            }

            System.out.println();
        }
    }
}


