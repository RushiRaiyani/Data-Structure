// Write a menu driven program to implement Binary Search Tree (BST) & perform 
// following operations
// Insert a node, Delete a node, Search a node


import java.util.Scanner;

public class BinarySearchTree {

    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Node t = null;

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

    public boolean equals(Node t, int value) {
        if (t == null) {
            return false;
        } else if (t.value == value) {
            return true;
        } else if (t.value > value) {
            return equals(t.left, value);
        } else {
            return equals(t.right, value);
        }
    }

    public Node delete(Node t, int value) {
        if (t == null) {
            System.out.println("The tree is empty");
            return null; // If the node is null, there's nothing to delete
        }
        if (t.value > value) {
            t.left = delete(t.left, value);
        } else if (t.value < value) {
            t.right = delete(t.right, value);
        } else {
            if (t.right == null && t.left == null) {
                return null;
            }
            if (t.right == null) {
                return t.left;
            } else if (t.left == null) {
                return t.right;
            }
            Node IS = inorderSuccessor(t.right);
            t.value = IS.value;
            t.right = delete(t.right, IS.value);
        }
        return t;
    }

    public Node inorderSuccessor(Node t) {
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // { 5,1,3,4,2,7 }
        Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        boolean isFound = true;
        while (isFound) {
            System.out.println("Enter 1 for insert:");
            System.out.println("Enter 2 for remove:");
            System.out.println("Enter 3 to exit:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter number to insert:");
                    int newValue = sc.nextInt();
                    tree.t = tree.buildTree(tree.t, newValue);
                    break;
                case 2:
                    System.out.println("Enter element to delete:");
                    int deleteValue = sc.nextInt();
                    tree.delete(tree.t, deleteValue);
                    break;
                case 3:
                    isFound = false;
                    break;
                default:
                    System.out.print("Enter a valid choice:");
            }
        }
        System.out.print("inorder traversal:");
        tree.inorder(tree.t);
    }
}
