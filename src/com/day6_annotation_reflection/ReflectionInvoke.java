package com.day6_annotation_reflection;
import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionInvoke {
    public static void main(String[] args) {
        try {
            // Creating an instance of Calculator
            Calculator calculator = new Calculator();

            // Getting the Class object
            Class<?> calculatorClass = calculator.getClass();

            // Accessing the private method 'multiply' using reflection
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            // Make the method accessible
            multiplyMethod.setAccessible(true);

            // Invoking the method and get the result
            int result = (int) multiplyMethod.invoke(calculator, 5, 6);

            // Displaying the result
            System.out.println("Multiplication Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
