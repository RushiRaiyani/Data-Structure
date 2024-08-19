// WAP to perform given operation in the linked list. There exist a Linked List. Add a node 
// that contains the GCD of that two nodes between every pair adjacent node of Linked List.
package LinkedList;

import java.util.Scanner;

class MyLinkedList {
    class Node {
        int value;
        Node link;

        public Node(int value) {
            this.value = value;
            this.link = null;
        }
    }

    Node first = null;

    public void insertAtFirst(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            first = newNode;
            newNode.link = temp;
        }
    }

    public void display() {
        Node save = first;
        if (save == null) {
            System.out.println("Linked List is empty");
        } else {
            while (save != null) {
                System.out.print(save.value + "-->");
                save = save.link;
            }
            System.out.println("null");
        }
    }

    public int gcdValue(int a, int b) {
        int pro = 1;
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                pro = i;
            }
        }
        return pro;
    }

    public void gcdNode() {
        Node save = first.link;
        Node prev = first;
        while (save != null) {
            Node newNode = new Node(gcdValue(save.value, prev.value));
            prev.link = newNode;
            newNode.link = save;
            prev = save;
            save = save.link;
        }

    }
}

public class GCDLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("Enter 1 to enter the element and 0 to terminate:");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    int element = sc.nextInt();
                    list.insertAtFirst(element);
                    break;
                case 0:
                    isEnd = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 0.");
                    break;
            }
        }
        list.gcdNode();
        list.display();
        sc.close();
    }
}
