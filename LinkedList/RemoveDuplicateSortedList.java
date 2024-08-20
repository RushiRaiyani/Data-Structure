// Write a program to remove the duplicates nodes from given sorted Linked List.
//  Input: 1 → 1 → 6 → 13 → 13 → 13 → 27 → 27
//  Output: 1 → 6 → 13 → 27
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

    public void checkDuplicate() {
        Node save = first;
        while (save != null && save.link != null) {
            Node prev = save;
            Node temp = save.link;
            while (temp != null) {
                if (save.value == temp.value) {
                    prev.link = temp.link;
                    temp = prev.link;
                } else {
                    prev = temp;
                    temp = temp.link;
                }
            }
            save = save.link;
        }
    }
}

public class RemoveDuplicateSortedList {
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
        list.checkDuplicate();
        list.display();
        sc.close();
    }
}
