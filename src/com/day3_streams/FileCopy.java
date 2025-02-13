package com.day3_streams;
import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\SampleText.txt";
        String destinationFile = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error occurred while copying the file: " + e.getMessage());
        }
    }
}

