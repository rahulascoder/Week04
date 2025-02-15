package com.day5_regex_junit;
import java.util.Scanner;

public class SpaceReducer {

    // Method to replace multiple spaces with a single space
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //user input
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        //Normalizing spaces
        String result = normalizeSpaces(text);
        System.out.println("Normalized Text: \"" + result + "\"");

        //closing scanner
        scanner.close();
    }
}
