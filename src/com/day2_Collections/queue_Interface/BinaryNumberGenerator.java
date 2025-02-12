package com.day2_Collections.queue_Interface;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {
    // Method to generate the first N binary numbers using a queue
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        //changing string of binar number to binary itself
        for (int i = 0; i < N; i++) {
            String binary = queue.poll();
            System.out.print(binary + " ");
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " Binary Numbers: ");
        //calling geneerate binary method
        generateBinaryNumbers(N);
    }
}
