package com.day3_streams;
import java.io.*;

public class StudentDataStreams {
    public static void main(String[] args) {
        // Define the binary file name
        String fileName = "student_data.bin";

        // Storing student details in the binary file
        //Using try catch block to handle exceptions
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            //Writing detals like roll no, name. grade
            dos.writeInt(101);
            dos.writeUTF("Rahul Kumar");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Vikash Yadav");
            dos.writeDouble(3.5);

            System.out.println("Student details stored successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Retrieving student details from the binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            // Checking if there is more data to read
            while (dis.available() > 0) {
                //Reading students details
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                //   student details
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
