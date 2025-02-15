package com.day5_regex_junit;
import java.util.Scanner;
import java.util.regex.*;
public class ExtractEmail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Taking user input
        System.out.println("Enter text :" );
        String text  = sc.nextLine();

        //regular expression for extracting email address
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pp = Pattern.compile(regex);
        Matcher matcher = pp.matcher(text);

        //Printing all emails
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
