package com.day1_Generic;

import java.util.ArrayList;
import java.util.List;

// Abstract Class Representing Course Type
abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (Evaluation: " + evaluationMethod + ")";
    }
}

// Concrete Course Types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

//assignment course inherit course type
class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}
//research course course inherit course type
class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

// Generic Course Class with Bounded Type Parameter
class Course<T extends CourseType> {
    private String courseName;
    private int credits;
    private T courseType;

    public Course(String courseName, int credits, T courseType) {
        this.courseName = courseName;
        this.credits = credits;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course{Name: " + courseName + ", Credits: " + credits + ", Type: " + courseType + "}";
    }
}

// Department Class Using Wildcards for Flexibility
class Department {
    private String departmentName;
    private List<Course<? extends CourseType>> courses;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Courses in " + departmentName + " Department:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

// Main Class for Execution
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating Different Course Instances
        Course<ExamCourse> math = new Course<>("Mathematics", 4, new ExamCourse());
        Course<AssignmentCourse> programming = new Course<>("Programming in Java", 3, new AssignmentCourse());
        Course<ResearchCourse> aiResearch = new Course<>("Artificial Intelligence Research", 5, new ResearchCourse());

        // Creating Departments
        Department scienceDepartment = new Department("Science & Engineering");
        Department humanitiesDepartment = new Department("Humanities");

        // Adding Courses to Departments
        scienceDepartment.addCourse(math);
        scienceDepartment.addCourse(programming);
        humanitiesDepartment.addCourse(aiResearch);

        // Displaying Courses in Departments
        scienceDepartment.displayCourses();
        humanitiesDepartment.displayCourses();
    }
}
