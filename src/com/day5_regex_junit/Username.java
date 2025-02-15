package com.day5_regex_junit;
import java.util.Scanner;

public class Username {

    //method to validate username regex
    public static boolean isValidUsername(String username){
        return username.matches("^[a-zA-Z0-9_]{4,14}$");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //user input to take username
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        //condition to check validity of username
        if (isValidUsername(username)) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username");
        }
        //closing scanner object
        scanner.close();
    }
}
