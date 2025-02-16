package com.day6_annotation_reflection;
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassReflection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Taking user input as class name
        System.out.print("Enter the class name: ");
        String className = scanner.nextLine();
        scanner.close();

        try {
            // Loading the class
            Class<?> clazz = Class.forName(className);

            // Displaying class name
            System.out.println("Class: " + clazz.getName());

            // Displaying constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Displaying methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            // Displaying fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}
