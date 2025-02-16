package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//Defining the @RoleAllowed annotation
//This annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to methods
@Target(ElementType.METHOD)
@interface RoleAllowed {
    // Specifying the required role
    String value();
}

//Creating Client class to simulate roles
class Client {
    private String role;

    //Client Constructor
    public Client(String role) {
        this.role = role;
    }

    //getRole mehtod
    public String getRole() {
        return role;
    }
}

//Applying @RoleAllowed to a method
class SecureService {

    // Only ADMIN users can execute this method
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully.");
    }
}

//Validating access using Reflection before invoking the method
public class RoleAllowedAnnotation {
    public static void main(String[] args) {
        //Creating adminClient and NormalClient Object of class Client
        Client adminClient = new Client("ADMIN");
        Client normalClient = new Client("CLIENT");

        //calling SecureService object
        SecureService service = new SecureService();

        System.out.println("Attempting to execute adminTask as ADMIN:");
        executeIfAllowed(service, "adminTask", adminClient);

        System.out.println("\nAttempting to execute adminTask as USER:");
        executeIfAllowed(service, "adminTask", normalClient);
    }

    private static void executeIfAllowed(Object obj, String methodName, Client user) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            // Checking if @RoleAllowed is present
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();

                // Checking if the user has the required role
                if (user.getRole().equals(requiredRole)) {
                    // Executing method if role matches
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! Only " + requiredRole + " users can execute this method.");
                }
            } else {
                // No restriction it execute normally
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
