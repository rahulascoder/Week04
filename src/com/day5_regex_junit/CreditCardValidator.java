package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;

public class CreditCardValidator {

    // Method to check if the credit card number is valid
    public static boolean isValidCreditCard(String cardNumber) {
        // Defining regex patterns for Visa and MasterCard
        // Starts with 4, followed by 15 digits for visa
        String visaPattern = "^4[0-9]{15}$";
        // Starts with 5, followed by 14 digits for mastercard
        String masterCardPattern = "^5[1-5][0-9]{14}$";

        // patterns
        Pattern visa = Pattern.compile(visaPattern);
        Pattern masterCard = Pattern.compile(masterCardPattern);

        // Matches input with patterns
        return visa.matcher(cardNumber).matches() || masterCard.matcher(cardNumber).matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a credit card number:");
        //user input
        String cardNumber = scanner.nextLine();

        // Validating the credit card number
        if (isValidCreditCard(cardNumber)) {
            System.out.println(" Valid Credit Card Number");
        } else {
            System.out.println(" Invalid Credit Card Number");
        }

        scanner.close();
    }
}
