package com.day1_Generic;

import java.util.ArrayList;
import java.util.List;

// Enum for Book Categories
enum BookCategory {
     SCIENCE;
}

// Enum for Clothing Categories
enum ClothingCategory {
    MEN;
}

// Enum for Gadget Categories
enum GadgetCategory {
    MOBILE ;
}

// Generic Product Class with Bounded Type Parameter
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

// Generic Utility to Apply Discount
class DiscountUtil {
    public static <T> void applyDiscount(Product<T> product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied: " + percentage + "% on " + product.getName() + ". New Price: " + product.getPrice());
    }
}

// Product Catalog to Store Various Products
class ProductCatalog {
    private List<Product<?>> productList = new ArrayList<>();

    public void addProduct(Product<?> product) {
        productList.add(product);
    }

    public void displayCatalog() {
        for (Product<?> product : productList) {
            System.out.println(product);
        }
    }
}

// main method for market place
public class Marketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Effective Java", 500, BookCategory.SCIENCE);
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 1200, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 30000, GadgetCategory.MOBILE);

        //creating object of ProductCatalog class
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("Before Discount:");
        catalog.displayCatalog();

        // Applying  Discount
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 15);
        DiscountUtil.applyDiscount(phone, 5);

        //After discount
        System.out.println("\nAfter Discount:");
        catalog.displayCatalog();
    }
}
