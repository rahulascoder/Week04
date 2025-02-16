package com.day6_annotation_reflection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Defining an Interface
interface Greeting {
    void sayHello(String name);
}

//Implementing the Interface
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

//Creating a Dynamic Proxy Handler
class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log method name before execution
        System.out.println("Invoking method: " + method.getName());

        // Execute the original method
        return method.invoke(target, args);
    }
}

// Use Proxy to Intercept Calls
public class DynamicProxyRefection {
    public static void main(String[] args) {
        // Create an instance of the original class
        Greeting greeting = new GreetingImpl();

        // Create a proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );

        // Call method via proxy
        proxyInstance.sayHello("Rudra");
    }
}
