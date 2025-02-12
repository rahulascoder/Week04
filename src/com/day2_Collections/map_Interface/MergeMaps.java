package com.day2_Collections.map_Interface;

import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        // input maps 1
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        //Input maps 2
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merging maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        //  result
        System.out.println(mergedMap);
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return result;
    }
}
