package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;

public class LicensePlateValidator {
    //method to check valid number plate
    public static boolean isValidLicensePlate(String plate) {
        //Regex for validating number plates
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Takinng input from user
        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();

        if (isValidLicensePlate(plate)) {
            System.out.println(" Valid license plate");
        } else {
            System.out.println(" Invalid license plate");
        }
        scanner.close();
    }
}
