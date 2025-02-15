package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;

public class HexColor {
    //Method to validate Hex Color
    public static boolean isValidHexColor(String color) {
        //  regex pattern for hex color pattern
        String hexPattern = "^#([A-Fa-f0-9]{6})$";

        Pattern pp = Pattern.compile(hexPattern);
        // Matching input with pattern
        Matcher matcher = pp.matcher(color);
        // Return if it matches
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Taking user input
        System.out.print("Enter a hex color code: ");
        String color = scanner.nextLine();

        //calling isValidate Method
        if (isValidHexColor(color)) {
            System.out.println(" Valid hex color");
        } else {
            System.out.println(" Invalid hex color");
        }

        //closing scanner class
        scanner.close();
    }
}

