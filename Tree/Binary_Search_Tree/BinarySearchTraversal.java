// Write a menu driven program to implement Binary Search Tree (BST) & perform 
// following operations
// 1. Preorder Traversal,2. Postorder Traversal,3. Inorder Traversal



import java.util.Scanner;

public class BinarySearchTraversal {
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

    public void inorder(Node t) {
        if (t == null) {
            return;
        }
        inorder(t.left);
        System.out.print(t.value + " ");
        inorder(t.right);
    }

    public void preorder(Node t) {
        if (t == null) {
            return;
        }
        System.out.print(t.value + " ");
        preorder(t.left);
        preorder(t.right);
    }

    public void postorder(Node t) {
        if (t == null) {
            return;
        }
        postorder(t.left);
        postorder(t.right);
        System.out.print(t.value + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFound = true;
        BinarySearchTraversal tree = new BinarySearchTraversal();
        // { 5,1,3,4,2,7 }
        while (isFound) {
            System.out.println("Enter 1 for insert:");
            System.out.println("Enter 2 for preorder traversal:");
            System.out.println("Enter 3 for inorder traversal:");
            System.out.println("Enter 4 for postorder traversal:");
            System.out.println("Enter 5 to exit:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter number to insert:");
                    int newValue = sc.nextInt();
                    tree.t = tree.buildTree(tree.t, newValue);
                    break;
                case 2:
                    System.out.print("Preorder Traversal of tree is:");
                    tree.preorder(tree.t);
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Inorder Traversal of tree is:");
                    tree.inorder(tree.t);
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Postorder Traversal of tree is:");
                    tree.postorder(tree.t);
                    System.out.println("");
                    break;
                case 5:
                    isFound = false;
                    break;
                default:
                    System.out.print("Enter a valid choice:");
            }
        }
    }
}
