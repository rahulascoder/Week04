package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Defining the @JsonField annotation
//This annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to fields
@Target(ElementType.FIELD)
@interface JsonField {
    // Custom JSON key name
    String name();
}

// Applying @JsonField to a User class
class User1 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User1(String username, int age) {
        this.username = username;
        this.age = age;
    }

    //Converting object to JSON string using reflection
    public String toJson() {
        try {
            //Using Map
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : this.getClass().getDeclaredFields()) {
                // Allow access to private fields
                field.setAccessible(true);

                if (field.isAnnotationPresent(JsonField.class)) {
                    String jsonKey = field.getAnnotation(JsonField.class).name();
                    Object value = field.get(this);
                    jsonMap.put(jsonKey, value.toString());
                }
            }

            // Converting map to JSON-like string
            StringBuilder jsonString = new StringBuilder("{");
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                jsonString.append("\"").append(entry.getKey()).append("\": ")
                        .append("\"").append(entry.getValue()).append("\", ");
            }

            // Removing trailing comma and space, then close JSON string
            if (jsonString.length() > 1) {
                jsonString.setLength(jsonString.length() - 2);
            }
            jsonString.append("}");

            return jsonString.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "{}";
    }
}

//Testing the annotation-based JSON serialization
public class JsonFiledAnnotation {
    public static void main(String[] args) {
        User1 user = new User1("Rahul Kumar", 25);
        // Converting User object to JSON string
        System.out.println(user.toJson());
    }
}
