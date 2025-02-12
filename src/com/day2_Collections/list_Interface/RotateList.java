package com.day2_Collections.list_Interface;

import java.util.*;

public class RotateList {

    //Rotation of list
    public static <T> void rotateList(List<T> list, int positions) {
        int n = list.size();

        // Handle cases where positions > size
        positions = positions % n;

        // Reversing the entire list
        reverse(list, 0, n - 1);
        // Reversing first part
        reverse(list, 0, n - positions - 1);
        // Reversing second part
        reverse(list, n - positions, n - 1);
    }

    // method to reverse a part of the list
    private static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int positions = 2;

        System.out.println("Original List: " + list);
        rotateList(list, positions);
        System.out.println("Rotated List: " + list);
    }
}
