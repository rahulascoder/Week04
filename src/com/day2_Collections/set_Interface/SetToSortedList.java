package com.day2_Collections.set_Interface;
import java.util.*;

public class SetToSortedList {

    // Method to converting a set to a sorted list
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        // Converting to list
        List<Integer> sortedList = new ArrayList<>(set);
        // Sorting in ascending order
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        //Input
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        //Creating an object of class convertToSortedList
        List<Integer> sortedList = convertToSortedList(set);
        System.out.println("Sorted List: " + sortedList);
    }
}
