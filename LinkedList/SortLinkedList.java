// Write a program to sort elements of a linked list.
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

    public void sort() {
        Node save = first;
        Node prev = null;
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            save = first;
            prev = null;
            while (save.link != null && save != null) {
                if (save.value > save.link.value) {
                    Node temp = save.link;
                    save.link = temp.link;
                    temp.link = save;
                    if (prev == null) {
                        first = temp;
                    } else {
                        prev.link = temp;
                    }
                    prev = temp;
                    isChanged = true;
                } else {
                    prev = save;
                    save = save.link;
                }
            }
            display();
        }
    }
}

public class SortLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        Scanner sc = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("Enter 1 to insert element and 0 to insert exit:");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    System.out.println("Enter the element to insert:");
                    int element = sc.nextInt();
                    list.insertAtFirst(element);
                    break;
                case 0:
                    isEnd = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        list.sort();
        list.display();
        sc.close();
    }
}
