package com.coderskills;

/**
 * There are some basic operations that allow us to perform different actions on a stack.
 * <p>
 * Push: Add an element to the top of a stack
 * Pop: Remove an element from the top of a stack
 * IsEmpty: Check if the stack is empty
 * IsFull: Check if the stack is full
 * Peek: Get the value of the top element without removing it
 */
public class StackArray {
    private final int capacity;
    public int[] array;
    public int topIndex;

    public StackArray(int capacity) {
        this.capacity = capacity;
        topIndex = -1;
        array = new int[this.capacity];
    }

    private boolean isFull() {
        return topIndex == capacity - 1;
    }

    private boolean isEmpty() {
        return topIndex == -1;
    }

    private boolean push(int value) {
        if (isFull()) {
            return false;
        }
        this.array[++topIndex] = value;
        return true;
    }

    private int pop() {
        if (isEmpty()) {
            return -1;
        }
       return array[topIndex--];
    }

    private void peek() {
        System.out.println("###########Printing peek value###################");
        if (isEmpty()) {
            System.out.println("Nothing to peek");
        } else {
            System.out.println(array[topIndex]);
        }
    }

    private void printStack() {
        System.out.println("###########Printing values from Array###################");
        if (isEmpty()) {
            System.out.println("Nothing to print");
        }else {
            for (int i = 0; i <= topIndex; i++) {
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("\nBefore popping out");
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("\nAfter popping out");
        stack.printStack();
        stack.peek();
    }
}
