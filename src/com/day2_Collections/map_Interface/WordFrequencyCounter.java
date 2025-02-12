package com.day2_Collections.map_Interface;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filePath) {
        // Create a HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Reading the file line by line
            while ((line = reader.readLine()) != null) {
                // Converting line to lowercase, remove punctuation, and split into words
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

                // Iterating through each word and update frequency count
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            // Handle file reading errors
            System.err.println("Error reading file: " + e.getMessage());
        }

        return wordCount;
    }

    public static void main(String[] args) {
        //  file path
        String filePath = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\com\\day2_Collections/input.txt";

        // Calling method to count word frequency
        Map<String, Integer> wordFrequency = countWordFrequency(filePath);

        // Printing the word frequencies
        System.out.println("Word Frequencies: " + wordFrequency);
    }
}
