package com.day6_annotation_reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//  Define @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Define Classes with Dependencies
class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

class Consumer {
    @Inject  // Marking this field for dependency injection
    private Service service;

    public void useService() {
        service.serve();
    }
}

//  Implement  DI Container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    // Registers and instantiates a class
    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        // Create an instance of the class
        T instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);

        // Inject dependencies
        injectDependencies(instance);

        return instance;
    }

    // Injects dependencies into fields marked with @Inject
    private void injectDependencies(Object instance) throws Exception {
        Class<?> clazz = instance.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = getInstance(fieldType);  // Get or create dependency

                field.setAccessible(true);  // Allow access to private fields
                field.set(instance, dependency);
            }
        }
    }
}

//  Test   DI Container
public class SimpleDI {
    public static void main(String[] args) {
        try {
            DIContainer container = new DIContainer();

            // Get an instance of Consumer with dependencies injected
            Consumer consumer = container.getInstance(Consumer.class);

            // Use the injected service
            consumer.useService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
