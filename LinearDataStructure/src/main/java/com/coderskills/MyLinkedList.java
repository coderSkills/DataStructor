package com.coderskills;

/**
 * This is a simple linked list
 * Traversal - access each element of the linked list
 * Insertion - adds a new element to the linked list
 * Deletion - removes the existing elements
 * Search - find a node in the linked list
 * Sort - sort the nodes of the linked list
 */
public class MyLinkedList {
    private Node root;
    private Node nextNode;

    public void insertAtBeginning(Node node) {
        if (root != null) {
            node.next = root;
        }
        root = node;
    }
    public void insertAtEnd(Node node) {
        if (root == null) {
            root = node;
        } else {
            Node currentNode = root;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    public void deleteAtBeginning() {
        if (root.next == null) {
            this.root = null;
        }
        else {
            root = root.next;
        }
    }
    public void deleteAtEnd() {
        if (root == null || root.next == null) {
            this.root = null;
        }else {
            Node currentNode = root;
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
        }
    }
    public boolean search(Node head, int val) {
        Node root = head;
        while (root != null) {
            if (root.key == val) return true;
            root = root.next;
        }
        return false;
    }

    public void traverse(Node head) {
        Node root = head;
        while (root != null) {
            System.out.println(root.key);
            root = root.next;
        }
    }
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        System.out.println("Before adding anything");
        linkedList.traverse(linkedList.root);
        System.out.println("Should be added in front 3->2->1");
        linkedList.insertAtBeginning(new Node(1));
        linkedList.insertAtBeginning(new Node(2));
        linkedList.insertAtBeginning(new Node(3));
        linkedList.traverse(linkedList.root);
        System.out.println("Should be added in front 3->2->1->4->5->6");
        linkedList.insertAtEnd(new Node(4));
        linkedList.insertAtEnd(new Node(5));
        linkedList.insertAtEnd(new Node(6));
        linkedList.traverse(linkedList.root);
        System.out.println("Should be removed from front 2->1->4->5->6");
        linkedList.deleteAtBeginning();
        linkedList.traverse(linkedList.root);
        System.out.println("Should be removed from front 2->1->4->5");
        linkedList.deleteAtEnd();
        linkedList.traverse(linkedList.root);
    }
}