package com.day3_streams;
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {

        //Using try catch block to avoid exception
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             //Address of file where we want to store data
             FileWriter writer = new FileWriter("user_data.txt")) {

            //Attributes like name, age, Programming Language
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            //Writing details in file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User information saved successfully to user_data.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while saving user information: " + e.getMessage());
        }
    }
}