package com.day1_Generic;

import java.util.*;

// Abstract class representing a Job Role
abstract class JobRole {
    String requiredSkills;
    int experienceRequired;

    public JobRole(String requiredSkills, int experienceRequired) {
        this.requiredSkills = requiredSkills;
        this.experienceRequired = experienceRequired;
    }

    public abstract String getRoleName();
}

// Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Java, Data Structures, Algorithms", 2);
    }

    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Python, Machine Learning, Statistics", 3);
    }

    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Communication, Market Research, Agile", 4);
    }

    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private String candidateName;
    private int yearsOfExperience;
    private String skills;
    private T jobRole;

    public Resume(String candidateName, int yearsOfExperience, String skills, T jobRole) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
        this.jobRole = jobRole;
    }

    public boolean isEligible() {
        return yearsOfExperience >= jobRole.experienceRequired && skills.contains(jobRole.requiredSkills);
    }

    public void printResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applying for: " + jobRole.getRoleName());
        System.out.println("Experience: " + yearsOfExperience + " years");
        System.out.println("Skills: " + skills);
        System.out.println("Eligibility: " + (isEligible() ? "Eligible" : "Not Eligible"));
        System.out.println("-----------------------------------");
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    public static void screenResumes(List<? extends JobRole> jobRoles, List<Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.printResume();
        }
    }
}

// Main Class
public class ResumeScreeningDemo {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();

        resumes.add(new Resume<>("Alice", 3, "Java, Data Structures, Algorithms", new SoftwareEngineer()));
        resumes.add(new Resume<>("Bob", 2, "Python, Machine Learning", new DataScientist()));
        resumes.add(new Resume<>("Charlie", 5, "Communication, Market Research, Agile", new ProductManager()));

        List<JobRole> jobRoles = Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());
        ResumeScreeningSystem.screenResumes(jobRoles, resumes);
    }
}
