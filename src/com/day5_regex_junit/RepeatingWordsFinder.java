package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;
import java.util.HashSet;

public class RepeatingWordsFinder {

    // Method to find repeating words in a sentence
    public static HashSet<String> findRepeatingWords(String text) {
        HashSet<String> words = new HashSet<>();
        HashSet<String> repeatedWords = new HashSet<>();

        // Regex pattern to match words
        String wordPattern = "\\b(\\w+)\\b";

        // pattern
        Pattern pattern = Pattern.compile(wordPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Finding all words
        while (matcher.find()) {
            // Converting to lowercase for case insensitivity
            String word = matcher.group().toLowerCase();
            // If already present then it is repeating word
            if (!words.add(word)) {
                repeatedWords.add(word);
            }
        }

        return repeatedWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        //user input
        String text = scanner.nextLine();

        // Extracting repeating words
        HashSet<String> result = findRepeatingWords(text);

        //result
        System.out.println("Repeating Words: " +  result);

        scanner.close();
    }
}
