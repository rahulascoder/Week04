package com.day2_Collections.map_Interface;
import java.util.*;

public class ShoppingCart {
    // HashMap to store product prices
    private Map<String, Double> productPrices;
    // Maintaining order of items added
    private LinkedHashMap<String, Integer> cart;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();

        // Adding sample products with prices
        productPrices.put("Laptop", 70000.0);
        productPrices.put("Headphones", 2000.0);
        productPrices.put("Mouse", 800.0);
        productPrices.put("Keyboard", 1500.0);
        productPrices.put("Monitor", 12000.0);
    }

    // Method to add item to cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
            System.out.println(product + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display items in order of addition LinkedHashMap
    public void displayCart() {
        System.out.println("\nShopping Cart (Order of Addition):");
        cart.forEach((product, quantity) ->
                System.out.println(product + " - " + quantity + " pcs - ₹" + productPrices.get(product) * quantity));
    }

    // Display items sorted by price   treemap
    public void displaySortedByPrice() {
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();

        for (String product : cart.keySet()) {
            sortedByPrice.put(productPrices.get(product), product);
        }

        System.out.println("\nShopping Cart (Sorted by Price):");
        sortedByPrice.forEach((price, product) ->
                System.out.println(product + " - ₹" + price + " per unit"));
    }

    // Calculating total bill
    public void calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        System.out.println("\nTotal Bill: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // Adding items to cart
        shoppingCart.addToCart("Laptop", 1);
        shoppingCart.addToCart("Mouse", 2);
        shoppingCart.addToCart("Headphones", 1);
        shoppingCart.addToCart("Monitor", 1);

        // Display cart
        shoppingCart.displayCart();
        shoppingCart.displaySortedByPrice();
        shoppingCart.calculateTotal();
    }
}
