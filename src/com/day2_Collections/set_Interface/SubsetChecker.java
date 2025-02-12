package com.day2_Collections.set_Interface;
import java.util.*;

public class SubsetChecker {

    // Method to checking if set1 is a subset of set2
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        // Checking if set2 contains all elements of set1
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        //first set
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        //second set
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        //Output
        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
    }
}

