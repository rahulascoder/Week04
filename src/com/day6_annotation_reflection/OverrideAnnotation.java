package com.day6_annotation_reflection;

class Animal {
    // Method named make sound
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class Dog
class Dog extends Animal {
    // Overriding the makeSound method
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main class to test the implementation
public class OverrideAnnotation {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
    }
}
