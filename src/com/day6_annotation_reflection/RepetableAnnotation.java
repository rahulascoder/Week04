package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//Defining the repeatable annotation
//This annotaiton is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to methods
@Target(ElementType.METHOD)
// Allowing multiple BugReport annotations
@Repeatable(BugReports.class)
@interface BugReport {
    // Field to store bug description
    String description();
}

//  Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    // Holding multiple BugReport annotations
    BugReport[] value();
}

//Applying multiple @BugReport annotations to a method
class SoftwareModule {

    @BugReport(description = "Null pointer exception occurs in edge cases.")
    @BugReport(description = "Performance issue in large datasets.")
    public void processData() {
        System.out.println("Processing data...");
    }
}

//Retrieving and print all bug reports using Reflection API
public class RepetableAnnotation {
    public static void main(String[] args) {
        try {
            // Getting the class reference
            Class<?> clazz = SoftwareModule.class;

            // Getting the method reference
            Method method = clazz.getMethod("processData");

            // Checking if the method has @BugReports annotations
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                System.out.println("Bug Reports:");
                for (BugReport bug : bugReports.value()) {
                    System.out.println("- " + bug.description());
                }
            }

            // Invoking the method
            SoftwareModule module = new SoftwareModule();
            module.processData();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
