package Module_3_3;

public class BankAccount {
    private static int totalAccounts = 0;
    private final int accountNumber;
    private double accountBalance;

    public BankAccount(double accountBalance) {
        this.accountNumber = ++totalAccounts;
        this.accountBalance = accountBalance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1500);
        BankAccount bankAccount1 = new BankAccount(2500);

        bankAccount.depositFunds(500);
        bankAccount1.withdrawFunds(1000);

        System.out.printf("Account %d has %.2f €\n", bankAccount.getAccountNumber(), bankAccount.getBalance());
        System.out.printf("Account %d has %.2f €\n", bankAccount1.getAccountNumber(), bankAccount1.getBalance());

        System.out.printf("Total number of accounts in the bank: %d", BankAccount.getTotalAccounts());
    }

    public void depositFunds(double amount) {
        if (amount > 0) {
            this.accountBalance += amount;
        } else {
            System.out.println("You can't deposit negative amount of money!");
        }
    }

    public void withdrawFunds(double amount) {
        if (this.accountBalance > amount) {
            this.accountBalance -= amount;
        } else {
            System.out.println("Not enough balance in your account!");
        }
    }

    public double getBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
