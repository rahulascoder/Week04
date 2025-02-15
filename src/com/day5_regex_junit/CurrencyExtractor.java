package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CurrencyExtractor {

    // Method to extract currency values from text
    public static ArrayList<String> extractCurrencyValues(String text) {
        ArrayList<String> currencyValues = new ArrayList<>();

        // Regex pattern to match currency values
        String currencyPattern = "\\$?\\d+\\.\\d{2}";

        // pattern
        Pattern pattern = Pattern.compile(currencyPattern);
        Matcher matcher = pattern.matcher(text);

        // Finding all matches and group them
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        return currencyValues;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        //Taking user input
        String text = scanner.nextLine();

        // Extracting currency values
        ArrayList<String> result = extractCurrencyValues(text);

        // result
        System.out.println("Extracted Currency Values: " + String.join(", ", result));

        scanner.close();
    }
}
