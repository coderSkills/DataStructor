package com.coderskills;

import java.util.ArrayList;
import java.util.List;

/**
 * Heapify(array, size, i)
 * set i as largest
 * leftChild = 2i + 1
 * rightChild = 2i + 2
 * <p>
 * if leftChild > array[largest]
 * set leftChildIndex as largest
 * if rightChild > array[largest]
 * set rightChildIndex as largest
 * <p>
 * swap array[i] and array[largest]
 * <p>
 * If there is no node,
 * create a newNode.
 * else (a node is already present)
 * insert the newNode at the end (last node from left to right.)
 * <p>
 * heapify the array
 */
public class PriorityQueue {

    private final int[] arr;
    private int lastIndex;
    private final int capacity;

    PriorityQueue(int capacity) {
        this.arr = new int[capacity];
        lastIndex = -1;
        this.capacity = capacity;
    }

    public boolean isFull() {
        return lastIndex + 1 == capacity;
    }

    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void heapify(int[] arr, int index) {
        if (index < 0) return;
        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 2;
        int largest = index;
        if (lastIndex>= leftIndex && arr[leftIndex] > arr[largest]) {
            largest = leftIndex;
        }
        if (lastIndex>=rightIndex && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }
        if (largest != index) {
            swap(arr, index, largest);
        }
        int parent = ((index + 1) / 2) - 1;
        heapify(arr, parent);
    }

    public boolean insert(int val) {
        if (isFull()) return false;
        if (lastIndex == -1) {
            this.arr[++lastIndex] = val;
        } else {
            this.arr[++lastIndex] = val;
            int parent = ((lastIndex + 1) / 2) - 1;
            heapify(this.arr, parent);
        }

        return true;
    }

    public boolean delete() {
        if (lastIndex == -1) return false;
        if (lastIndex == 0) return true;
        swap(arr, 0, lastIndex);
        lastIndex--;
        int parent = ((lastIndex + 1) / 2) - 1;
        heapify(arr, parent);
        return true;
    }

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(7);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        System.out.println("Printing elements ");
        queue.printArray();
        queue.insert(8);
        System.out.println("Trying to add element more then index. it should not be added");
        queue.printArray();
        queue.delete();
        System.out.println("Removed the top priority value");
        queue.printArray();
    }

    private void printArray() {
        for (int i = 0; i <= lastIndex; i++) {
            System.out.println(arr[i]);
        }
    }
}
