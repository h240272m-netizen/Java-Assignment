package bankingSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Abstract class Bank
abstract class Bank {
    protected String accountName;
    protected double balance;

    public Bank(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract double getBalance();

    // Helper method to log transactions into Bank.txt
    protected void logTransaction(String message) {
        try (FileWriter fw = new FileWriter("Bank.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            System.out.println("Error writing to Bank.txt: " + e.getMessage());
        }
    }
}

// Account class that extends Bank
class Account extends Bank {

    public Account(String accountName, double balance) {
        super(accountName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            logTransaction(accountName + " deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Must be greater than 0.");
            logTransaction("Failed deposit attempt by " + accountName + " with amount " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            logTransaction(accountName + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Withdrawal amount exceeded account balance");
            logTransaction("Failed withdrawal attempt by " + accountName + " with amount " + amount);
        }
    }

    @Override
    public double getBalance() {
        logTransaction(accountName + " checked balance. Current balance: " + balance);
        return balance;
    }
}

// Main class to test Account
public class Main {
    public static void main(String[] args) {
        Account acc = new Account("John Doe", 5000);

        // Test deposits
        acc.deposit(2000);
        acc.deposit(-50);  // invalid deposit

        // Test withdrawals
        acc.withdraw(1000);
        acc.withdraw(7000); // exceeds balance

        // Test balance check
        System.out.println("Final Balance: " + acc.getBalance());
    }
}
