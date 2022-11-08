package com.coderskills;

/**
 * A queue is an object (an abstract data structure - ADT) that allows the following operations:
 * <p>
 * Enqueue: Add an element to the end of the queue
 * Dequeue: Remove an element from the front of the queue
 * IsEmpty: Check if the queue is empty
 * IsFull: Check if the queue is full
 * Peek: Get the value of the front of the queue without removing it
 */
public class QueueArray {
    private int[] array;
    private final int capacity;
    private int front;
    private int rear;

    QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    private boolean isFull() {
        return rear == capacity - 1;
    }

    private boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
    }

    private boolean enQueue(int value) {
        if(isFull()) return false;
        if(isEmpty()) {
            front++;
        }
        array[++rear]=value;
        return true;
    }

    private int deQueue() {
        if(isEmpty()) return -1;
        if (front==rear) {
            front = -1;
            rear = -1;
        }else {
            front++;
        }
        return array[front];
    }

    private void peek() {
        System.out.println("###########Printing peek value###################");
        if (isEmpty()) {
            System.out.println("Nothing to peek");
        } else {
            System.out.println(array[front]);
        }
    }

    private void display() {
        System.out.println("###########Printing values from Array###################");
        if (isEmpty()) {
            System.out.println("Nothing to print");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 6th element can't be added to because the queue is full
        q.enQueue(6);

        q.display();

        // deQueue removes element entered first i.e. 1
        q.deQueue();

        // Now we have just 4 elements
        q.display();

    }
}
