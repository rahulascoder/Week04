package com.day2_Collections.list_Interface;
import java.util.*;

public class RemoveDuplicates {
    // Method to remove duplicates while preserving order
    public static <T> List<T> removeDuplicates(List<T> list) {
        // Storing unique element
        Set<T> seen = new HashSet<>();
        // Storing final output
        List<T> result = new ArrayList<>();


        //using for each loop to add items list named result
        for (T item : list) {
            // If not already present then adding to both
            if (seen.add(item)) {
                result.add(item);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //Input
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);


        System.out.println("List before removing duplicates: " + list);


        //calling removeDuplicates method using object
        List<Integer> uniqueList = removeDuplicates(list);
        //printing result
        System.out.println("List after removing duplicates: " + uniqueList);
    }
}

