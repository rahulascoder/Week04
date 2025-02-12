package com.day2_Collections.map_Interface;

import java.util.*;

public class MapUtils {
    // Method to finding the key with the highest value
    public static <K, V extends Comparable<V>> K findKeyWithMaxValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        // input map
        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("A", 10);
        sampleMap.put("B", 20);
        sampleMap.put("C", 15);

        // Finding the key with the highest value
        String maxKey = findKeyWithMaxValue(sampleMap);

        //  result
        System.out.println("Key with the highest value: " + maxKey);
    }
}
