package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//  Defining the @LogExecutionTime annotation
//This annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to methods
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

//Creating a class with methods using the annotation
class PerformanceTester {

    //for small time
    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
        for (int i = 0; i < 1000; i++);
    }

    //for larger time
    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        for (int i = 0; i < 1000000; i++);
    }
}

//Using Reflection to measure execution time
public class LogExecution {
    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();
        Class<?> clazz = PerformanceTester.class;

        // Iterating through all declared methods
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                // Measuring execution time
                long startTime = System.nanoTime();
                method.invoke(tester);
                long endTime = System.nanoTime();

                // Print execution time in milliseconds
                System.out.println(method.getName() + " executed in " + (endTime - startTime) / 1_000_000.0 + " ms\n");
            }
        }
    }
}
