package com.day2_Collections.list_Interface;
import java.util.*;


public class FrequencyOfElement {
    public static void main(String[] args) {
        // Creating and initializing the list
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");


        // Using a HashMap to store frequencies
        Map<String, Integer> frequencyMap = new HashMap<>();


        // Counting occurrences using getOrDefault()
        for (String word : list) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }


        // Printing the result
        System.out.println(frequencyMap);
    }
}
