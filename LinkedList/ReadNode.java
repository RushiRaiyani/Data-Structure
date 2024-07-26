package LinkedList;

import java.util.Scanner;

class MyLinkedList {
    public void display(int a, Node b) {
        System.out.println("Node is:value in node is:" + a + ",address in node is:" + b);
    }
}

class Node {
    int value;
    Node link;

    public Node(int value) {
        this.value = value;
        this.link = null;
    }
}

public class ReadNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        System.out.println("Enter a number to enter in node:");
        int n = sc.nextInt();
        Node newNode = new Node(n);
        list.display(newNode.value, newNode.link);
        sc.close();
    }
}
