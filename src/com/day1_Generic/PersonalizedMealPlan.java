package com.day1_Generic;

import java.util.ArrayList;
import java.util.List;

// Interface for Meal Plan
interface MealPlan {
    String getMealDetails();
}

// Subtypes of MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: Includes vegetables, grains, dairy, and legumes.";
    }
}

//vegan meal inherit from meal plan
class VeganMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegan Meal: Includes plant-based foods, no animal products.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Keto Meal: High-fat, low-carb diet including meat, eggs, and cheese.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "High-Protein Meal: Focuses on lean meats, fish, and protein-rich foods.";
    }
}

// Generic Meal Class with Bounded Type Parameter
class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;

    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "Name='" + mealName + '\'' +
                ", Type=" + mealType.getMealDetails() +
                '}';
    }
}

// Meal Plan Generator with Generic Method
class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generating meal plan for: " + meal.getMealName());
        System.out.println(meal.getMealType().getMealDetails());
    }
}

// Meal Plan Collection Using Wildcards
class MealCollection {
    private List<Meal<? extends MealPlan>> meals = new ArrayList<>();

    public void addMeal(Meal<? extends MealPlan> meal) {
        meals.add(meal);
    }

    public void displayMeals() {
        System.out.println("\nAvailable Meal Plans:");
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println(meal);
        }
    }
}

// Main Class
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        // Creating Meal Instances
        Meal<VegetarianMeal> vegMeal = new Meal<>("Vegetarian Delight", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Vegan Power", new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Keto Blast", new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>("Protein Boost", new HighProteinMeal());

        // Generating Meal Plans
        MealPlanGenerator.generateMealPlan(vegMeal);
        MealPlanGenerator.generateMealPlan(veganMeal);
        MealPlanGenerator.generateMealPlan(ketoMeal);
        MealPlanGenerator.generateMealPlan(proteinMeal);

        // Managing Meal Collection
        MealCollection mealCollection = new MealCollection();
        mealCollection.addMeal(vegMeal);
        mealCollection.addMeal(veganMeal);
        mealCollection.addMeal(ketoMeal);
        mealCollection.addMeal(proteinMeal);

        // Display All Meal Plans
        mealCollection.displayMeals();
    }
}

