interface Loanable {
    void applyForLoan();
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public abstract double calculateInterest();

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan() {
        System.out.println("Loan applied for Savings Account.");
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    public double calculateInterest() {
        return 0; // No interest
    }

    public void applyForLoan() {
        System.out.println("Loan applied for Current Account.");
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 50000;
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SA1001", "Alice", 15000),
            new CurrentAccount("CA2002", "Bob", 60000)
        };

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Interest Earned: ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan();
                System.out.println("Loan Eligible: " + loan.calculateLoanEligibility());
            }

            System.out.println("-------------------------");
        }
    }
}
