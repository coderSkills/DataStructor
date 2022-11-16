package com.coderskills;

public class BalancedBinaryTree {
    Node root;

    private boolean checkHeightBalance(Node root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();
        boolean l = checkHeightBalance(root.left, lHeight);
        boolean r = checkHeightBalance(root.right, rHeight);
        height.height = Math.max(lHeight.height, rHeight.height)+1;
        if ((lHeight.height - rHeight.height >= 2) || (rHeight.height - lHeight.height >= 2))
            return false;

        else
            return l && r;

    }

    public static void main(String args[]) {
        Height height = new Height();

        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.checkHeightBalance(tree.root, height))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}
