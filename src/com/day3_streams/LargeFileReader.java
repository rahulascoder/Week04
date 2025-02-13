package com.day3_streams;
import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        //Accessing path of file
        String fileName = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\500mbFile.txt";

        // Using try catch to ensure proper resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Reading each line from the file
            while ((line = reader.readLine()) != null) {
                // Checking if the line contains "error" words
                if (line.toLowerCase().contains("error")) {
                    // If word is matching then printing that line
                    System.out.println(line);
                }
            }
        }// Handling  IO exceptions that may occur
        catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
