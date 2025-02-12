package com.day2_Collections.queue_Interface;

import java.util.Arrays;

public class CircularBuffer {

    //attributes
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    //constructor
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    //method to inserting values in buffer
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }

    //getting buffer
    public int[] getBuffer() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer()));
        cb.insert(4);
        cb.insert(6);
        System.out.println("Buffer after inserting 4: " + Arrays.toString(cb.getBuffer()));
    }
}
