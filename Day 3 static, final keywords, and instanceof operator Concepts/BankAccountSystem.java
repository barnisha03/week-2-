class BankAccount {
    private static int totalAccounts = 0;
    public static String bankName = "Global Bank";

    private final String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName; // using this to resolve ambiguity
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Bank Name: " + bankName);
        }
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", "ACC123");
        BankAccount acc2 = new BankAccount("Bob", "ACC456");

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        BankAccount.getTotalAccounts();
    }
}









