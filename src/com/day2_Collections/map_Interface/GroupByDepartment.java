package com.day2_Collections.map_Interface;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    //attibiutes
    private String name;
    private String department;

    //constructor
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    //getter
    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        //  employee list
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "IT"),
                new Employee("Eve", "Finance")
        );

        // Grouping employees by department
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        //   result
        groupedEmployees.forEach((dept, empList) ->
                System.out.println(dept + ": " + empList));
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

