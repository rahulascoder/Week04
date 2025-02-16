package com.day6_annotation_reflection;
import java.util.ArrayList;

public class SuppressWarning {
    // Suppressing unchecked type warnings
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Creating an ArrayList without generics
        ArrayList list = new ArrayList();

        // Adding elements without specifying type
        list.add("Hello");
        list.add(100);
        list.add(3.14);

        // Retrieving elements without type safety
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
