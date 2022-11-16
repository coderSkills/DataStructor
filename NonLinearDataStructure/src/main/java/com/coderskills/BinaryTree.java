package com.coderskills;


/**
 * Below statement is true for binary tree
 * 1. Single node or multiple node.
 * 2. should have max two child nodes
 * Types of binary tree
 * Complete binary tree
 * full  binary tree
 * perfect binary tree
 * balanced binary tree
 * pathological tree
 * skewed binary tree
 */
public class BinaryTree {
    private Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Pre order Traversal: ");
        tree.traversePreOrder(tree.root);
        System.out.print("\nIn order Traversal: ");
        tree.traverseInOrder(tree.root);
        System.out.print("\nPost order Traversal: ");
        tree.traversePostOrder(tree.root);

        System.out.println("\nis full binary tree  :: " + tree.isFullBinaryTree(tree.root));
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("\nis perfect binary tree :: " + tree.isPerfectBinaryTree(tree.root));
        System.out.println(tree.numberOfNodes(tree.root));
    }

    public int numberOfNodes(Node root) {
        if (root == null) return 0;
        return (1 + numberOfNodes(root.right) + numberOfNodes(root.left));
    }

    private void traverseInOrder(Node node) {
        if (node == null) return;
        traverseInOrder(node.left);
        System.out.print(node.key + " ");
        traverseInOrder(node.right);

    }

    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.key + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);

    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.key + " ");
    }

    /**
     * should have two child or null child
     * Let, i = the number of internal nodes
     * n = be the total number of nodes
     * l = number of leaves
     * λ = number of levels
     * <p>
     * The number of leaves is i + 1.
     * The total number of nodes is 2i + 1.
     * The number of internal nodes is (n – 1) / 2.
     * The number of leaves is (n + 1) / 2.
     * The total number of nodes is 2l – 1.
     * The number of internal nodes is l – 1.
     * The number of leaves is at most 2λ - 1
     *
     * @param node
     * @return
     */
    public boolean isFullBinaryTree(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }
        return false;
    }

    public int depth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    public boolean isPerfectBinaryTree(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null) {
            int leftDepth = depth(node.left);
            int rightDepth = depth(node.right);
            return leftDepth == rightDepth && isPerfectBinaryTree(node.left) && isPerfectBinaryTree(node.right);
        }
        return false;
    }
}
