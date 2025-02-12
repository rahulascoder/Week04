package com.day2_Collections.map_Interface;

import java.util.*;

public class BankingSystem {
    // HashMap to store account balances
    private Map<Integer, Double> accounts;
    // Queue for processing withdrawals
    private Queue<Integer> withdrawalQueue;

    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();

        // Adding sample accounts
        accounts.put(1001, 5000.0);
        accounts.put(1002, 12000.0);
        accounts.put(1003, 8000.0);
        accounts.put(1004, 15000.0);
    }

    // Method to deposit money
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
            System.out.println("₹" + amount + " deposited into Account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to request withdrawal added to queue
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for Account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Process withdrawals
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("₹" + amount + " withdrawn from Account " + accountNumber);
            } else {
                System.out.println("Insufficient funds in Account " + accountNumber);
            }
        }
    }

    // Displaying accounts sorted by balance using TreeMap
    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        sortedAccounts.forEach((balance, accountNumber) ->
                System.out.println("Account " + accountNumber + " -> ₹" + balance));
    }

    // Displaying all accounts
    public void displayAccounts() {
        System.out.println("\nCurrent Account Balances:");
        accounts.forEach((accountNumber, balance) ->
                System.out.println("Account " + accountNumber + " -> ₹" + balance));
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Depositing money
        bank.deposit(1001, 2000);
        bank.deposit(1003, 3000);

        // Requesting withdrawals
        bank.requestWithdrawal(1001);
        bank.requestWithdrawal(1004);
        bank.requestWithdrawal(1002);

        // Processing withdrawals
        bank.processWithdrawals(5000);

        // Displaying account balances
        bank.displayAccounts();
        bank.displaySortedAccounts();
    }
}

