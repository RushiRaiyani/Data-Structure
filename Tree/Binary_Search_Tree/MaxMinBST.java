// WAP to find the smallest and largest elements in the Binary Search Tree.


import java.util.Scanner;

public class MaxMinBST {
    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node t = null;

    public Node buildTree(Node t, int value) {
        if (t == null) {
            t = new Node(value);
            return t;
        }
        Node newNode = new Node(value);
        if (newNode.value > t.value) {
            t.right = buildTree(t.right, value);
        } else {
            t.left = buildTree(t.left, value);
        }
        return t;
    }

    static int min = 0;
    static int max = 0;

    public void maxValue(Node root) {
        if (root.value >= max) {
            max = root.value;
        }
        return;
    }

    public void minValue(Node root) {
        if (root.value <= min) {
            min = root.value;
        }
        return;
    }

    public void inorder(Node t) {
        if (t == null) {
            return;
        }
        inorder(t.left);
        minValue(t);
        maxValue(t);
        inorder(t.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFound = true;
        MaxMinBST tree = new MaxMinBST();
        // { 5,1,3,4,2,7 }
        while (isFound) {
            System.out.println("Enter 1 for insert:");
            System.out.println("Enter 2 to exit:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter number to insert:");
                    int newValue = sc.nextInt();
                    tree.t = tree.buildTree(tree.t, newValue);
                    break;
                case 2:
                    isFound = false;
                    break;
                default:
                    System.out.print("Enter a valid choice:");
            }
        }
        min = tree.t.value;
        max = tree.t.value;
        tree.inorder(tree.t);
        System.out.println("Max value is:" + max);
        System.out.println("Min value is:" + min);
    }
}
