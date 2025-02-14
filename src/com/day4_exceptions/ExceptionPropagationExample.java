package com.day4_exceptions;
public class ExceptionPropagationExample {
    public static void method1() {
        // This will throw ArithmeticException
        int result = 10 / 0;
    }

    public static void method2() {
        //calling method 1
        method1();
    }

    public static void main(String[] args) {
        try {
            //calling method 2
            method2();cd
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
