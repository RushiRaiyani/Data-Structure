// Write a program to copy a linked list.
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
                System.out.print(save.value + " ");
                save = save.link;
            }
            System.out.println("");
        }
    }

    public void insertAtLast(int value) {
        Node newNode = new Node(value);
        Node save = first;
        if (first == null) {
            first = newNode;
        } else {
            while (save.link != null) {
                save = save.link;
            }
            save.link = newNode;
        }
    }

    public void copy(MyLinkedList list2) {
        Node save = first;
        while (save != null) {
            list2.insertAtLast(save.value);
            save = save.link;
        }
    }
}

public class CopyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("Enter the elements of list1, Enter 1 to enter the element and 0 to terminate:");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    int element = sc.nextInt();
                    list1.insertAtFirst(element);
                    break;
                case 0:
                    isEnd = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 0.");
                    break;
            }
        }
        list1.copy(list2);
        System.out.println("Copied Linked List is:");
        list2.display();
        sc.close();
    }
}
