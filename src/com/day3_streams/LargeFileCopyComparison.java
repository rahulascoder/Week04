package com.day3_streams;

import java.io.*;

public class LargeFileCopyComparison {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\100mbFile.txt";
        String destinationFileBuffered = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\destination_buffered.txt";
        String destinationFileUnbuffered = "C:\\Users\\Hp\\Desktop\\Java Training\\Week4\\src\\destination_unbuffered.txt";

        long startTime, endTime;

        // Copy using unbuffered streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            startTime = System.nanoTime();

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            endTime = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error occurred while copying the file: " + e.getMessage());
        }

        // Copy using buffered streams
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            startTime = System.nanoTime();

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            endTime = System.nanoTime();
            System.out.println("Buffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error occurred while copying the file: " + e.getMessage());
        }
    }
}
