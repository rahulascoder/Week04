package com.java_junit;
public class StringUtils {

    //method to reverse string
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    //method to check palindrom
    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    //Method to convert string in upper case
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
