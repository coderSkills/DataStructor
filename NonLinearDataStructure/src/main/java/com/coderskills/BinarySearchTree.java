package com.coderskills;

public class BinarySearchTree {
    private Node root;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.print("search value: ");
        boolean status = tree.search(10);
        System.out.println(status);
        System.out.println("\n\nAfter deleting 10");
//        tree.deleteKey(14);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }

    private boolean search(int value) {
        Node currentNode = this.root;
        if (currentNode.key == value) return true;
        while(currentNode!=null){
            if (currentNode.key == value) return true;
            if(currentNode.key > value) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
        return false;
    }

    private Node minValue(Node node) {
        if (node == null) return ;
        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);
    }

//    private void deleteKey(int value) {
//root = deleteKey(this.root, value)
//    }
//
//    private Node deleteKey(Node node, int value) {
//        if (node == null) return null;
//
//        if (node.left == null && node.right == null) {
//            if (node.key == value) {
//                return
//            }
//        } else if (root.left == null) {
//            if (root.key == value) {
//                this.root = root.right;
//            }
//        } else if (root.right == null) {
//            if (root.key == value) {
//                this.root = root.left;
//            }
//        } else {
//            root = deleteKey(this.root, value);
//        }
//    return null;
//
//    }

    private void inorder() {
        this.inorder(this.root);
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);
    }

    /**
     * If node == NULL
     * return createNode(data)
     * if (data < node->data)
     * node->left  = insert(node->left, data);
     * else if (data > node->data)
     * node->right = insert(node->right, data);
     * return node;
     *
     * @param value
     */
    private void insert(int value) {
        this.root = insert(this.root, value);
    }

    private Node insert(Node node, int value) {
        Node newNode = new Node(value);
        if (node == null) return newNode;
        if (node.key < value) node.right = insert(node.right, value);
        else node.left = insert(node.left, value);
        return node;
    }
}
