package com.day4_exceptions;

import java.io.*;

public class FileRead {
    public static void main(String[] args) {
        //FIle name
        String fileName = "info.txt";

        //using try catch block
        //Using BufferReader to read lines in file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            }
        } catch (IOException e) {
            System.out.println("Error reading file. ");
        }
    }
}
