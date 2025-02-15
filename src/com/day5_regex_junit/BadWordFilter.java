package com.day5_regex_junit;
import java.util.Scanner;
import java.util.ArrayList;

public class BadWordFilter {

    // Method to replace bad words with "****"
    public static String censorBadWords(String text, ArrayList<String> badWords) {
        for (String badWord : badWords) {
            //Regex for replacing all bad words with ****
            text = text.replaceAll("(?i)\\b" + badWord + "\\b", "****");  // Case-insensitive match
        }
        //returning replaced words
        return text;
    }

    // Method to take input and show result
    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        //User input
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        // Defining bad words using ArrayList
        ArrayList<String> badWords = new ArrayList<>();
        badWords.add("damn");
        badWords.add("baster");
        badWords.add("fuck");
        badWords.add("hell");
        badWords.add("stupid");

        // Putting bad words in result
        String result = censorBadWords(text, badWords);
        System.out.println("Censored Text: \"" + result + "\"");

        scanner.close();
    }

    public static void main(String[] args) {
        // Calling method
        processInput();
    }
}
