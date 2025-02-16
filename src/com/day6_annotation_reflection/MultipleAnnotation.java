package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//   Defining the custom annotation
//This annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to methods
@Target(ElementType.METHOD)
@interface ImportantMethod {
    // Optional parameter with default value
    String level() default "HIGH";
}

//  Applying annotation to multiple methods
class TaskManagers {

    @ImportantMethod // Uses default level "HIGH"
    public void criticalTask() {
        System.out.println("Executing a critical task...");
    }

    // Custom importance level
    @ImportantMethod(level = "MEDIUM")
    public void importantTask() {
        System.out.println("Executing an important task...");
    }

    public void regularTask() {
        System.out.println("Executing a regular task...");
    }
}

//Retrieving and print annotated methods using Reflection API
public class MultipleAnnotation {
    public static void main(String[] args) {
        // Getting  class reference
        Class<?> clazz = TaskManager.class;

        System.out.println("Important Methods:");

        // Iterating through all declared methods
        for (Method method : clazz.getDeclaredMethods()) {
            // Checking if the method has @ImportantMethod annotation
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                // Retrieve annotation details
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("- " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }

        // Executing  methods
        TaskManagers taskManager = new TaskManagers();
        taskManager.criticalTask();
        taskManager.importantTask();
        taskManager.regularTask();
    }
}
