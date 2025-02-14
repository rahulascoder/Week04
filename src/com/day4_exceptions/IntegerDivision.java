package com.day4_exceptions;
import java.util.*;

public class IntegerDivision {
    public static void main(String[] args) {
        //Creating scanner object
        Scanner scanner = new Scanner(System.in);

        //using try catch block to handle exception
        try {
            //Taking numerator
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            //Taking denominator
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers.");
        //using finally to close operations
        } finally {
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}

