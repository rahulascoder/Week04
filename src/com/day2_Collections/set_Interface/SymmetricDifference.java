package com.day2_Collections.set_Interface;

import java.util.*;

public class SymmetricDifference {

    // Method to computing the symmetric difference of two sets
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> temp = new HashSet<>(set2);

        // Removing common elements from set1
        result.removeAll(set2);
        // Removing common elements from set2
        temp.removeAll(set1);

        // Combining both unique elements
        result.addAll(temp);
        return result;
    }

    public static void main(String[] args) {
        //first set
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        //second set
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}
