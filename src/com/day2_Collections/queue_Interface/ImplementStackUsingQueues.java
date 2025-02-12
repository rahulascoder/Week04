package com.day2_Collections.queue_Interface;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    //Taking two queues
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Pushing element into stack
    public void push(int x) {
        queue1.add(x);
    }

    // Removing the element on top of the stack
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.poll();

        // Swaping the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Getting the top element of the stack
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.add(queue1.poll());

        // Swaping the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.top());
    }
}

