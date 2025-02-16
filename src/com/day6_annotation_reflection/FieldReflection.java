package com.day6_annotation_reflection;
import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class FieldReflection {
    public static void main(String[] args) {
        try {
            // Creating an instance of Person
            Person person = new Person(25);
            person.displayAge();

            // Getting the Class object
            Class<?> personClass = person.getClass();

            // Access the private field 'age' using reflection
            Field ageField = personClass.getDeclaredField("age");

            // Make the field accessible
            ageField.setAccessible(true);

            // Modifing the age value
            ageField.set(person, 30);

            // Retrieving the modified age value
            int modifiedAge = (int) ageField.get(person);
            System.out.println("Modified Age: " + modifiedAge);

            // Displaying updated age
            person.displayAge();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
