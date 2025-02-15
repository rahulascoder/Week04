package com.java_junit;
import java.util.List;

public class ListManager {
     //Adding an element to the list.
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    //Removing an element from the list.
    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

     // Returning the size of the list.
    public int getSize(List<Integer> list) {
        return list.size();
    }
}

