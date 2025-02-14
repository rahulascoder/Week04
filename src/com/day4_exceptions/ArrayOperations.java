package com.day4_exceptions;
import java.util.*;

public class ArrayOperations {
    //Method to get value and index of an array
    public static void getValueAtIndex(int[] array, int index) {
        try {
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Initializing array with NULL
        int[] array = null;

        //Try catch block to handle ArrayIndexOutOfBoundsException  and NullPointerException
        try {
            System.out.print("Enter the size of the array: ");
            //Taking array size
            int size = scanner.nextInt();
            array = new int[size];

            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }

            //Retriving the index we want
            System.out.print("Enter the index to retrieve value: ");
            int index = scanner.nextInt();
            getValueAtIndex(array, index);

        //using catch block to handle InputMismatchException
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}

