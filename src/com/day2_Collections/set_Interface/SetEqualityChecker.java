package com.day2_Collections.set_Interface;

import java.util.*;

public class SetEqualityChecker {

    // Method to check if two sets are equal
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        //directly checking equality of sets
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        //First set
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        //Second set
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("Are the sets equal? " + areSetsEqual(set1, set2));
    }
}
