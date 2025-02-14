package com.day4_exceptions;

import java.util.Scanner;

//Custom exception class to handle INvalidAgeException
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class CustomException {
    //Method to throw message if age is below 18
    static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be greater than and equal to 18");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter age: ");
        int age=sc.nextInt();

      //Try catch block to catch exception
      try{
          validateAge(age);
          System.out.println("Access granted!");
      }catch(InvalidAgeException e){
          System.out.println("Custom Exception handled. " + e.getMessage());
      }

    }
}
