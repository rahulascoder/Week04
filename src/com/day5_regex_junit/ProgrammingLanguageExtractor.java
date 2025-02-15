package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ProgrammingLanguageExtractor {

    // Method to extract programming language names from text
    public static ArrayList<String> extractLanguages(String text) {
        ArrayList<String> languages = new ArrayList<>();

        // List of programming languages
        String[] languageList = {"JavaScript", "Java", "Python", "C++", "C#", "Go", "Ruby", "Swift", "Kotlin", "PHP"};

        // Loop through each language and check for matches
        for (String lang : languageList) {
            String regex = "\\b" + lang + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            //finding matches of language
            if (matcher.find()) {
                languages.add(lang);
            }
        }
        return languages;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        //Taking user input
        String text = scanner.nextLine();

        // Extracting programming languages
        ArrayList<String> result = extractLanguages(text);

        // Printing result
        System.out.println("Extracted Programming Languages: " + result);

        scanner.close();
    }
}
