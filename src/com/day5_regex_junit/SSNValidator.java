package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;

public class SSNValidator {

    // Method to check if an SSN is valid
    public static boolean isValidSSN(String ssn) {
        // Define regex pattern for SSN (format: XXX-XX-XXXX)
        String ssnPattern = "^\\d{3}-\\d{2}-\\d{4}$";

        //  pattern
        Pattern pattern = Pattern.compile(ssnPattern);
        Matcher matcher = pattern.matcher(ssn);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Social Security Number (SSN):");
        String ssn = scanner.nextLine();

        // Validating the SSN
        if (isValidSSN(ssn)) {
            System.out.println(" \"" + ssn + "\" is valid");
        } else {
            System.out.println(" \"" + ssn + "\" is invalid");
        }

        scanner.close();
    }
}

