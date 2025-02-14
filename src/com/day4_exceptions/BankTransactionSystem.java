package com.day4_exceptions;
import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

//creating Bank Account class
class BankAccount {
    private double balance;

    //constructor for class bank account
    public BankAccount(double balance) {
        this.balance = balance;
    }

    //method to withdraw amount
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //using try catch block to handle exceptioin
        try {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            BankAccount account = new BankAccount(initialBalance);

            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);

        //using mutiple catch block to handle exxception
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
