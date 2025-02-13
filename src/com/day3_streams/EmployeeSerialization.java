package com.day3_streams;
import java.io.*;
import java.util.*;

// Employee class that implements Serializable to allow object serialization
class Employee implements Serializable {
    //Attributes
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor to initialize Employee object
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    // Overriding toString method to display employee details
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeSerialization {
    //file name
    private static final String FILE_NAME = "employees.ser";

    // Method to serialize a list of employees into a file
    public static void serializeEmployees(List<Employee> employees) {
        //Taking try catch block to avoid exceptions
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }
    // Method to deserialize employee list from the file and display them
    public static void deserializeEmployees() {
        //Taking try catch block to avoid exceptions
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Rahul Yadav", "HR", 50000));
        employees.add(new Employee(2, "Hritik Maurya", "IT", 60000));
        employees.add(new Employee(3, "Rudra Ray", "Finance", 70000));

        // Serializing the list of employees
        serializeEmployees(employees);
        // Deserializing and displaying the employee list
        deserializeEmployees();
    }
}
