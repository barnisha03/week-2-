import java.util.ArrayList;
import java.util.List;

// Account class - represents individual bank accounts
class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

// Customer class - associated with one or more accounts
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Balances for " + name + ":");
        for (Account acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() + ", Bank: " + acc.getBank().getName() + ", Balance: $" + acc.getBalance());
        }
        System.out.println();
    }
}

// Bank class - associated with customers and opens accounts
class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public Account openAccount(Customer customer, String accNumber, double initialDeposit) {
        Account newAccount = new Account(accNumber, initialDeposit, this);
        customer.addAccount(newAccount);
        return newAccount;
    }

    public String getName() {
        return name;
    }
}

// Main class to demonstrate association
public class AssociationDemo {
    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        Bank sbi = new Bank("SBI Bank");

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Associate customers with bank accounts
        hdfc.openAccount(alice, "HDFC001", 5000);
        sbi.openAccount(alice, "SBI001", 3000);
        hdfc.openAccount(bob, "HDFC002", 10000);

        // Customers view their balances
        alice.viewBalance();
        bob.viewBalance();
    }
}














