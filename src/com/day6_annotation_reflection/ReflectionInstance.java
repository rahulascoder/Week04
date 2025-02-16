package com.day6_annotation_reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class ReflectionInstance{
    public static void main(String[] args) {
        try {
            // Using .class instead of Class.forName()
            Class<?> studentClass = Student.class;

            // Getting the default constructor
            Constructor<?> constructor = studentClass.getDeclaredConstructor();

            // Creating an instance dynamically
            Object studentInstance = constructor.newInstance();

            // Invoking the display method
            Method displayMethod = studentClass.getMethod("display");
            displayMethod.invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
