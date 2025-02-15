package com.day5_regex_junit;
import java.util.regex.*;
import java.util.Scanner;

public class IPAddress {

    // Method to validate an IPv4 address
    public static boolean isValidIPv4(String ip) {
        // Regex pattern for IPv4 validation
        String ipv4Pattern ="^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}" + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

        // Compiling the pattern
        Pattern pattern = Pattern.compile(ipv4Pattern);
        // matcher to match IP Address
        Matcher matcher = pattern.matcher(ip);

        //if match found the return true else false
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an IP address:");
        //Taking user input as IP address
        String ip = scanner.nextLine();

        // ValidatingIP address
        if (isValidIPv4(ip)) {
            System.out.println("Valid IPv4 address");
        } else {
            System.out.println("Invalid IPv4 address");
        }
        scanner.close();
    }
}

