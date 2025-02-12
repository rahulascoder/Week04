package com.day2_Collections.map_Interface;
import java.io.*;
import java.util.*;

public class MapInverter {
    // Method to invert a Map<K, V> to Map<V, List<K>>
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Iterating through each entry in the original map
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            // Adding the key to the list corresponding to the value
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        //   input maps
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Calling invertMap method
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Printing the inverted map
        System.out.println("Original Map: " + originalMap);
        System.out.println("Inverted Map: " + invertedMap);
    }
}
