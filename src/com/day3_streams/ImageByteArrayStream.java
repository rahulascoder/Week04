package com.day3_streams;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageByteArrayStream {
    public static void main(String[] args) {
        //Path of source and destination Image
        String sourceImage = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\source_image.jpg";
        String destinationImage = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\copied_image.jpg";

        //Using try catch block to handle exception
        try {
            // Reading image file into a byte array
            byte[] imageBytes = Files.readAllBytes(new File(sourceImage).toPath());

            // Converting byte array to ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);

            // Converting ByteArrayInputStream back to ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // Write the byte array to a new image file
            Files.write(new File(destinationImage).toPath(), baos.toByteArray());

            // Verify if both files are identical
            byte[] newImageBytes = Files.readAllBytes(new File(destinationImage).toPath());
            if (Arrays.equals(imageBytes, newImageBytes)) {
                System.out.println("The copied image is identical to the original.");
            } else {
                System.out.println("The copied image differs from the original.");
            }
        } catch (IOException e) {
            System.out.println("Error processing the image: " + e.getMessage());
        }
    }
}
