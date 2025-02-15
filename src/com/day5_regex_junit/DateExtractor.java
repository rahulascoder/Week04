package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;

public class DateExtractor {

    // Method to extract and print all dates in dd/mm/yyyy format
    public static void extractDates(String text) {
        // regex pattern for dates
        String datePattern = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})\\b";

        //  pattern
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(text);

        //initailly we assume date not found
        boolean found = false;
        System.out.print("Extracted Dates are : ");
        //Finding date and returning
        while (matcher.find()) {
            if (found) {
                System.out.print(", ");
            }
            System.out.print(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.print("No valid dates found.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        // method to extract dates
        extractDates(text);
        scanner.close();
    }
}
