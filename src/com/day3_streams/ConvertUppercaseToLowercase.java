package com.day3_streams;
import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        // Defining source and destination file names
        String sourceFile = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\SampleText.txt";
        String destinationFile = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\destination.txt";

        // Try Catch block to ensure proper resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            // Reading each line from the source file
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            // Printing success message after file conversion
            System.out.println("File converted successfully with lowercase letters.");
        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }
}
