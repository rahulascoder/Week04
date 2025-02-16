package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
//This annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to methods
@Target(ElementType.METHOD)
@interface MaxLength {
    // Defines the max allowed length
    int value();
}

//Applying @MaxLength to the User class field
class User {

    private String username;

    //Constructor
    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    //Validating the length using Reflection
    private void validateMaxLength(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Testing annotation by creating User objects
public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try {
            User user1 = new User("RahulKumar");
            System.out.println("User created with username: " + user1.getUsername());

            // Exceeds max length, should throw an exception
            User user2 = new User("Ram Gopal Bhatachariya Purohit");
            System.out.println("User created with username: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
