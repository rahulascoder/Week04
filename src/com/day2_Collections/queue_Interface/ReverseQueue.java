package com.day2_Collections.queue_Interface;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    // Method to reverse the queue
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }

        // Removing the front element
        int front = queue.poll();

        // Recursively reversing the remaining queue
        queue = reverseQueue(queue);

        // Adding the removed element back to the rear
        queue.add(front);

        return queue;
    }

    public static void main(String[] args) {
        //creating object of queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        //original queue
        System.out.println("Original Queue: " + queue);

        //calling reverse method
        queue = reverseQueue(queue);

        //output
        System.out.println("Reversed Queue: " + queue);
    }
}
