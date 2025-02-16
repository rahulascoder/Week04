package com.day6_annotation_reflection;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//Define the @CacheResult annotation
//This annotation is available at runtime
@Retention(RetentionPolicy.RUNTIME)
// Can only be applied to methods
@Target(ElementType.METHOD)
@interface CacheResult {}

//Creating a class with a computationally expensive method
class ExpensiveOperations {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeFactorial(int num) {
        // Checking cache first
        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for " + num);
            return cache.get(num);
        }

        // Computing factorial
        System.out.println("Computing factorial for " + num);
        int result = (num <= 1) ? 1 : num * computeFactorial(num - 1);

        // Storing result in cache
        cache.put(num, result);
        return result;
    }
}

//Invoking method with caching logic
public class CacheAnnotation {
    public static void main(String[] args) throws Exception {
        ExpensiveOperations operations = new ExpensiveOperations();

        System.out.println("Factorial of 5: " + executeWithCache(operations, "computeFactorial", 5));
        System.out.println("Factorial of 5 (cached): " + executeWithCache(operations, "computeFactorial", 5));
        System.out.println("Factorial of 6: " + executeWithCache(operations, "computeFactorial", 6));
    }

    private static Object executeWithCache(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            // Calling method with caching logic inside
            return method.invoke(obj, args);
        }
        // Normal execution if no annotation
        return method.invoke(obj, args);
    }
}
