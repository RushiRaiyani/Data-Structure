// Write a program to swap two consecutive nodes in the linked list. Don’t change 
// the values of nodes, implement by changing the link of the nodes.
// 1. Input: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
// 2. Output: 2 → 1 → 4 → 3 → 6 → 5 → 8 → 7
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

    public void consecutiveNodeSwap() {
        if (first == null || first.link == null) {
            return;
        }
        Node temp;
        Node save = first.link;
        Node prev = first;
        if (save.link != null) {
            temp = save.link;
            first = save;
        } else {
            first = save;
            save.link = prev;
            prev.link = null;
            return;
        }
        while (temp != null && temp.link != null) {
            prev.link = temp.link;
            save.link = prev;
            prev = temp;
            save = temp.link;
            temp = save.link;

        }
        if (temp == null || temp.link == null) {
            save.link = prev;
            prev.link = temp;
        } else {
            save.link = prev;
            prev.link = null;
        }
    }
}

public class ConsecutiveSwap {
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
        list.consecutiveNodeSwap();
        list.display();
        sc.close();
    }
}
