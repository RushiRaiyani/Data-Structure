// Write a program to check whether the given tree is symmetric or not.
package BinaryTree;

import java.util.Scanner;

public class SymmetricBT {
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
    int index = -1;

    public Node buildTree(int arr[]) {
        index++;
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }
        Node newNode = new Node(arr[index]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }

    int temp = 1;

    public void symmetricity(Node tree, Node tree2) {
        if (tree == null && tree2 == null) {
            return;
        }
        if (tree == null || tree2 == null) {
            temp = -1;
            return;
        }
        symmetricity(tree.left, tree2.right);
        System.out.println("hello");
        if (tree.value != tree2.value) {
            temp = -1;
        }
        symmetricity(tree.right, tree2.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SymmetricBT tree = new SymmetricBT();
        System.out.println("Enter size of tree 1:");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter elements in tree 1:");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter number at index [" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        tree.t = tree.buildTree(arr);
        tree.symmetricity(tree.t.left, tree.t.right);
        if (tree.temp == 1) {
            System.out.println("Both trees are similar");
        } else {
            System.out.println("Both trees are not similar");
        }
    }
}
