package com.day4_exceptions;
import java.util.*;

public class InterestCalculator {
    //creating method to calculateInterest
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //Taking amount
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            //Taking amount
            System.out.print("Enter rate: ");
            double rate = scanner.nextDouble();
            //Taking amount
            System.out.print("Enter years: ");
            int years = scanner.nextInt();
            //calculating interest
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        //Handling exceptions using catch block
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values.");
        } finally {
            scanner.close();
        }
    }
}
