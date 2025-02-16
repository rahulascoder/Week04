package com.day6_annotation_reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//Defining the custom annotation @Author
// Making annotation available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to classes
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

//Applying the annotation to a class
// Assign an author name
@Author(name = "Rahul Kumar")
class MyClass {
    public void display() {
        System.out.println("Inside MyClass method");
    }
}

//  Reflection to retrieve and display the annotation
public class AnnotaionReflectionAtRunTime {
    public static void main(String[] args) {
        // Get the Class object of MyClass
        Class<?> myClass = MyClass.class;

        // Check if the @Author annotation is present
        if (myClass.isAnnotationPresent(Author.class)) {
            // Retrieve the annotation
            Author authorAnnotation = myClass.getAnnotation(Author.class);

            // Display the annotation value
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
