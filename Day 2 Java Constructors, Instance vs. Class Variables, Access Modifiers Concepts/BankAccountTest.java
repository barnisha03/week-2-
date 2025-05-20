class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Accessor and mutator for private balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Subclass demonstrating access to public and protected members
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void display() {
        System.out.println("Account Number (public): " + accountNumber);
        System.out.println("Account Holder (protected): " + accountHolder);
        System.out.println("Balance (via getter): " + getBalance());
    }
}

public class BankAccountTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("ACC12345", "Bob", 2500.75);
        sa.display();

        sa.setBalance(3000.00);
        System.out.println("Updated Balance: " + sa.getBalance());
    }
}








