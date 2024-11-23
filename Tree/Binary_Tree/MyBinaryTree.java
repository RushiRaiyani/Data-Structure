package BinaryTree;

import java.util.*;

public class MyBinaryTree {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Node root = null;

    int idx = -1;

    public Node buildTree(int arr[]) {
        idx++;
        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }
        System.out.println("");
        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }

    public void preorder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public void postorder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    public void levelOrder(Node root) {
        if (root == null) {
            System.out.println("Empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node current = q.remove();
            if (current == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(current.value + " ");
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }
        System.out.println("Enter the number of nodes to build tree");
        int number = sc.nextInt();
        MyBinaryTree tree = new MyBinaryTree();
        while (true) {
            System.out.println("Enter 1 to enter elements in array:");
            System.out.println("Enter 2 for preoder traversal");
            System.out.println("Enter 3 for inorder traversal");
            System.out.println("Enter 4 for postorder traversal");
            System.out.println("Enter 5 for level order traversal");
            System.out.println("Enter 6 to terminate traversal");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    if (number == 0) {
                        System.out.println("Tree is empty");
                    } else {
                        int[] nodes = new int[number];
                        for (int i = 0; i < number; i++) {
                            System.out.println("nodes[" + i + "] = ");
                            nodes[i] = sc.nextInt();
                        }

                        tree.root = tree.buildTree(nodes);
                        System.out.println(tree.root.value);
                    }
                    break;
                case 2:
                    System.out.print("Preoder:");
                    tree.preorder(tree.root);
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Inorder:");
                    tree.inorder(tree.root);
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Postoder:");
                    tree.postorder(tree.root);
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Leveloder:");
                    tree.levelOrder(tree.root);
                    System.out.println("");
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
