package com.day6_annotation_reflection;
import java.lang.reflect.Field;
import java.util.Arrays;

// class for conversion
class Person2 {
    private String name;
    private int age;
    private boolean isStudent;

    public Person2(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }
}

public class ObjectToJsonConverter {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Allow access to private fields
            try {
                Object value = field.get(obj);
                json.append("\"").append(field.getName()).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        // Create an instance of Person
        Person2 person = new Person2("Rudra", 30, true);

        // Convert to JSON-like string
        String jsonString = toJson(person);

        // Display the output
        System.out.println(jsonString);
    }
}

