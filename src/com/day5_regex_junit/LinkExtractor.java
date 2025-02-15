package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;

public class LinkExtractor {

    // Method to extract and print all links from the text
    public static void extractLinks(String text) {
        // regex pattern
        String urlPattern = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/\\S*)?\\b";

        // pattern
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(text);

        //initailly we assume link not found
        boolean found = false;
        System.out.print("Extracted Links: ");
        //finding all links and  then printing links
        while (matcher.find()) {
            if (found) {
                System.out.print(", ");
            }
            System.out.print(matcher.group());
            found = true;
        }

        //if not found
        if (!found) {
            System.out.print("No valid links found.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Taking user input
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        //Calling method to extract links
        extractLinks(text);
        //closing scanner
        scanner.close();
    }
}
