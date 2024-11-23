// Write a program to check whether the given two trees are same or not.
package BinaryTree;

import java.util.Scanner;

public class SimilarityBt {
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
    public Node t2 = null;

    int idx = -1;

    public Node buildTree(int arr[]) {
        idx++;
        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }

    int temp = 1;

    public void similar(Node t, Node tree2) {
        if (t == null && tree2 == null) {
            return;
        }
        if (t == null || tree2 == null) {
            temp = -1;
            return;
        }
        similar(t.left, tree2.left);
        if (t.value != tree2.value) {
            temp = -1;
        }
        similar(t.right, tree2.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = sc.nextInt();
        System.out.println("Enter size of array:");
        int size2 = sc.nextInt();
        // { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }
        int arr[] = new int[size];
        int arr2[] = new int[size2];
        SimilarityBt tree = new SimilarityBt();
        if (size == 0 || size2 == 0) {
            System.out.println("Tree not possible for 0 nodes");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println("Enter value at index " + i);
                arr[i] = sc.nextInt();
            }
            tree.t = tree.buildTree(arr);

            System.out.println("Enter elements of tree 2:");
            for (int i = 0; i < size2; i++) {
                System.out.println("Enter value at index " + i);
                arr2[i] = sc.nextInt();
            }
            tree.t2 = tree.buildTree(arr2);
        }
        tree.similar(tree.t, tree.t2);

        if (tree.temp == 1) {
            System.out.println("Both trees are similar");
        } else {
            System.out.println("Both trees are not similar");
        }
    }
}
