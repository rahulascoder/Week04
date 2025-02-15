package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWord {

    // Method to extract all capitalized words from the text
    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();

        // Regex pattern for capitalized words
        String capitalizedPattern = "\\b[A-Z][a-z]*\\b";

        //  pattern
        Pattern pattern = Pattern.compile(capitalizedPattern);
        Matcher matcher = pattern.matcher(text);

        // Extracting all matching words
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Taking user input
        System.out.println("Enter the sentence:");
        String text = scanner.nextLine();

        // Calling method to capitalize word
        List<String> result = extractCapitalizedWords(text);
        System.out.println("Extracted Capitalized Words: " + result);
        //closing scanner object
        scanner.close();
    }
}

