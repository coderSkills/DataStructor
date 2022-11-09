package com.coderskills;

/**
 * How Circular Queue Works
 * Circular Queue works by the process of circular increment i.e. when we try to increment the pointer ,and we reach the end of the queue,
 * we start from the beginning of the queue.
 * Here, the circular increment is performed by modulo division with the queue size. That is,
 * <p>
 * if REAR + 1 == 5 (overflow!), REAR = (REAR + 1)%5 = 0 (start of queue)
 * Circular Queue Operations
 * The circular queue work as follows:
 * <p>
 * two pointers FRONT and REAR
 * FRONT track the first element of the queue
 * REAR track the last elements of the queue
 * initially, set value of FRONT and REAR to -1
 */
public class CircularQueue {
    private int[] array;
    private final int capacity;
    private int front;
    private int rear;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    private boolean isFull() {
        int nextIndex = (this.rear + 1) % capacity;
        return (front == 0 && rear == capacity - 1) || (nextIndex == front);
    }

    private boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
    }

    private boolean enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            front=0;
        }
        rear = (rear+1) % capacity;
        array[rear] = value;
        System.out.println("Inserted value :: " +value);
        return true;
    }

    private int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int frontIndex = front;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front+1) % capacity;
        }
        System.out.println("removing index" +frontIndex);
        return array[frontIndex];
    }

    private void peek() {
        System.out.println("###########Printing peek value###################");
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println(array[front]);
        }
    }

    private void display() {
        int i;
        System.out.println("###########Printing values from Array###################");
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("front :: " + front);
            System.out.println("Items");
            for (i = front; i != rear; i = (i + 1) % capacity) {
                System.out.println(array[i]);
            }
            System.out.println(array[i]);
            System.out.println("rear :: " + rear);
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        // Fails because front = -1
        q.deQueue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // Fails to enqueue because front == 0 && rear == SIZE - 1
        q.enQueue(6);

        q.display();

        int elem = q.deQueue();

        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();

        q.enQueue(7);

        q.display();

        // Fails to enqueue because front == rear + 1
        q.enQueue(8);

    }
}
