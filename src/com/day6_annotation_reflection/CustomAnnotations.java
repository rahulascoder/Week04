package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//Creating custom annotation
// This annotaiton is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to methods
@Target(ElementType.METHOD)
@interface TaskInfo {
    //Priority filed
    int priority();
    // Person responsible for the task
    String assignedTo();
}

// Applying  annotation to a method
class TaskManager {

    @TaskInfo(priority = 1, assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }
}

// Retrieving annotation details using Reflection API
public class CustomAnnotations {
    public static void main(String[] args) {
        //Using try catch block to handle exceptioin
        try {
            // Getting class reference
            Class<?> clazz = TaskManager.class;

            // Getting the method reference
            Method method = clazz.getMethod("completeTask");

            // Checking if the annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Retrieving annotation details
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            // Invoking the method
            TaskManager taskManager = new TaskManager();
            taskManager.completeTask();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
