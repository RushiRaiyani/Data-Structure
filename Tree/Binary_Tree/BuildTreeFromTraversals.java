// Write a program to construct a binary tree from given postorder and preorder 
// traversal sequence.
package BinaryTree;

import java.util.Scanner;

public class BuildTreeFromTraversals {
    class Node {
        int info;
        Node lpter;
        Node rpter;

        public Node(int data) {
            info = data;
            lpter = null;
            rpter = null;
        }
    }

    public Node t = null;
    int preIndex = 0;
    int postIndex;

    public Node bTFPreorder(int[] io, int[] po, int s, int e) {

        if (s > e) {
            return null;
        }

        Node newNode = new Node(po[preIndex]);
        preIndex++;
        if (t == null) {
            t = newNode;
        }
        if (s == e) {
            return newNode;
        }
        int inorderIndex = searchIndex(io, s, e, newNode.info);
        newNode.lpter = bTFPreorder(io, po, s, inorderIndex - 1);
        newNode.rpter = bTFPreorder(io, po, inorderIndex + 1, e);

        return newNode;
    }

    public Node bTFPostorder(int[] io, int[] po, int s, int e) {

        if (s > e) {
            return null;
        }

        Node newNode = new Node(po[postIndex]);
        postIndex--;
        if (t == null) {
            t = newNode;
        }
        if (s == e) {
            return newNode;
        }
        int inorderIndex = searchIndex(io, s, e, newNode.info);
        newNode.lpter = bTFPostorder(io, po, inorderIndex + 1, e);
        newNode.rpter = bTFPostorder(io, po, s, inorderIndex - 1);

        return newNode;
    }

    int searchIndex(int[] io, int s, int e, int data) {
        for (int i = s; i <= e; i++) {
            if (io[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public void RPREORDER(Node t) {
        if (t == null) {
            return;
        }
        System.out.print(t.info + " ");
        RPREORDER(t.lpter);
        RPREORDER(t.rpter);

    }

    public void RPOSTORDER(Node t) {
        if (t == null) {
            return;
        }

        RPOSTORDER(t.lpter);
        RPOSTORDER(t.rpter);
        System.out.print(t.info + " ");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of nodes in the tree:");
        int n = sc.nextInt();

        System.out.println("Enter the inorder traversal:");
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("inorder[" + i + "]=");
            inorder[i] = sc.nextInt();
            System.out.println();
        }

        System.out.println("Enter 1 if you want to build tree using preorder traversal");
        System.out.println("Enter 2 if you want to build tree using postorder traversal");
        System.out.print("choice:");
        int choice = sc.nextInt();
        System.out.println();

        if (choice == 1) {
            System.out.println("Enter the preorder traversal:");
            int[] preorder = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("preorder[" + i + "]=");
                preorder[i] = sc.nextInt();
                System.out.println();
            }

            BuildTreeFromTraversals bt = new BuildTreeFromTraversals();
            bt.bTFPreorder(inorder, preorder, 0, n - 1);
            bt.RPOSTORDER(bt.t);

        } else if (choice == 2) {
            System.out.println("Enter the postorder traversal:");
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("postorder[" + i + "]=");
                postorder[i] = sc.nextInt();
                System.out.println();
            }

            BuildTreeFromTraversals bt = new BuildTreeFromTraversals();
            bt.postIndex = postorder.length - 1;
            bt.bTFPostorder(inorder, postorder, 0, n - 1);
            bt.RPREORDER(bt.t);

        } else {
            System.out.println("Invalid choice");
        }
    }
}