package com.day2_Collections.queue_Interface;

import java.util.PriorityQueue;
import java.util.Queue;

class Patient implements Comparable<Patient> {
    //Patients common details
    String name;
    int severity;

    //constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        // Higher severity first
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        //Creating object of queue
        Queue<Patient> triageQueue = new PriorityQueue<>();

        // Adding patients to the queue
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        //Printing output
        System.out.println("Order of treatment:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}

