package com.day6_annotation_reflection;
import java.lang.reflect.Method;

//   class with methods to measure execution time
class Task {
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }

    public void slowMethod() {
        try {
            Thread.sleep(1000); // Simulate a slow method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow method executed.");
    }
}

//   Utility class to measure execution time using Reflection
class MethodTimer {
    public static void measureExecutionTime(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            // Only invoke methods with no parameters
            if (method.getParameterCount() == 0) {
                try {
                    long startTime = System.nanoTime();
                    // Execute method
                    method.invoke(obj);
                    long endTime = System.nanoTime();

                    // Convert time to milliseconds
                    long executionTime = (endTime - startTime) / 1_000_000;
                    System.out.println("Method " + method.getName() + " executed in " + executionTime + " ms.");

                } catch (Exception e) {
                    System.out.println("Error executing method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}

//  the Reflection-based Method Timer
public class ReflectionMethodTimer {
    public static void main(String[] args) {
        // Create an instance of Task
        Task task = new Task();
        // Measure execution time for all methods
        MethodTimer.measureExecutionTime(task);
    }
}
