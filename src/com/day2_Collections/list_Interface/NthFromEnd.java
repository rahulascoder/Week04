package com.day2_Collections.list_Interface;

import java.util.*;

public class NthFromEnd {

    // Method to find the Nth element from the end
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> slow = list.iterator();
        Iterator<T> fast = list.iterator();

        // Moving fast pointer N steps ahead
        for (int i = 0; i < n; i++) {
            // If N is greater than size
            if (!fast.hasNext()) return null;
            fast.next();
        }

        // Moving both slow and fast until fast reaches the end
        T nthElement = null;
        while (fast.hasNext()) {
            nthElement = slow.next();
            fast.next();
        }

        return nthElement;
    }

    public static void main(String[] args) {
        //Taking input
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        String result = findNthFromEnd(list, n);
        System.out.println("The " + n + "th element from the end is: " + result);
    }
}
