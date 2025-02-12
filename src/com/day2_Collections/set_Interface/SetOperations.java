package com.day2_Collections.set_Interface;
import java.util.*;

public class SetOperations {

    // Method to computing the union of two sets
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        // Add all elements from set2 to set1
        unionSet.addAll(set2);
        return unionSet;
    }

    // Method to computing the intersection of two sets
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> intersectionSet = new HashSet<>(set1);
        // Keeping only elements present in both sets
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static void main(String[] args) {
        //first set
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        //second set
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }
}

