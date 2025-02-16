package com.day6_annotation_reflection;
import java.lang.reflect.Field;

class Configuration {
    //Attribute
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ReflectionModifyStatic {
    public static void main(String[] args) {
        try {
            // Getting the Class object of Configuration
            Class<?> configClass = Configuration.class;

            // Access the private static field "API_KEY"
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible
            apiKeyField.setAccessible(true);

            // Modify the static field value
            apiKeyField.set(null, "NEW_SECRET_KEY");

            // Print the modified value
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
