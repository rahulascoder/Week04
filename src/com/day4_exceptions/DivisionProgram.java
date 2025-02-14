package com.day4_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionProgram {
    public static void main(String[] args) {

        //creating scanner class to take input from user
        Scanner sc = new Scanner(System.in);

        //try catch block to handle exceptions
        try{
            //Taking numerator and denominator
            System.out.println("Enter  numerator");
            int numerator = sc.nextInt();
            System.out.println("Enter  denominator");
            int denominator = sc.nextInt();

            //Result of the output
            int result = numerator/denominator;
            System.out.println("Result is : " + result );
        }catch (ArithmeticException e){
            System.out.println("Division by zero is not allowed ");
        }catch (InputMismatchException e){
            System.out.println("Please enter valid number");
        }
        finally {
            sc.close();
        }
    }
}
