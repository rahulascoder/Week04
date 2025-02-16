package com.day6_annotation_reflection;
import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();

            // Getting the Class object
            Class<?> mathClass = mathOps.getClass();

            // Taking user input for method name and parameters
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.next();

            //Taking user input of two number
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Getting method dynamically based on the user input
            Method method = mathClass.getMethod(methodName, int.class, int.class);

            // Invoking the method dynamically
            Object result = method.invoke(mathOps, num1, num2);

            // Displaying the result
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
