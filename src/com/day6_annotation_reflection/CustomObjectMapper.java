package com.day6_annotation_reflection;
import java.lang.reflect.Field;
import java.util.Map;

// Sample class to demonstrate mapping
class Person1 {
    //Person's attributes
    private String name;
    private int age;

    //Display method
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Creating a new instance of the given class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterating through map entries and set field values
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    // Getting the field from the class
                    Field field = clazz.getDeclaredField(fieldName);

                    // Make the field accessible if it's private
                    field.setAccessible(true);

                    // Set the field value
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: No such field '" + fieldName + "' in " + clazz.getSimpleName());
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Object mapping failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //  properties map
        Map<String, Object> personData = Map.of(
                "name", "Rudra Ray",
                "age", 30
        );

        // Convert map to Person object
        Person1 person = toObject(Person1.class, personData);

        // Display mapped object
        person.display();
    }
}
