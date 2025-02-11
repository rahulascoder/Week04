package com.day1_Generic;
import java.util.*;

// Abstract class representing a Warehouse Items
abstract class WarehouseItem {
    private String name;
    private double price;

    //constructor for warehouse class
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getter for taking name of an item
    public String getName() {
        return name;
    }

    //getter for taking price of an item
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Electronic item types extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}
// Groceries item types extending WarehouseItem
class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}
// Furniture item types extending WarehouseItem
class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

// Generic Storage class ensuring type safety
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T retrieveItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getItems() {
        return items;
    }

    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Testing the Smart Warehouse System
public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 1200.50));
        electronicsStorage.addItem(new Electronics("Smartphone", 699.99));

        groceriesStorage.addItem(new Groceries("Apple", 1.99));
        groceriesStorage.addItem(new Groceries("Milk", 3.49));

        furnitureStorage.addItem(new Furniture("Chair", 75.00));
        furnitureStorage.addItem(new Furniture("Table", 150.00));

        // Displaying all items using wildcard method
        System.out.println("Electronics:");
        Storage.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        Storage.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        Storage.displayItems(furnitureStorage.getItems());
    }
}
