// Write a program to count the number of nodes in a singly circularly linked list.
package CircularLinkedList;

import java.util.Scanner;

class CircularLinkedList {
    class Node {
        int value;
        Node link;

        public Node(int value) {
            this.value = value;
            this.link = null;
        }
    }

    Node first = null;
    Node last = null;

    public void cirInsertAtFirst(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = last = newNode;
            newNode.link = first;
            return;
        }
        newNode.link = first;
        last.link = newNode;
        first = newNode;
    }

    public void display() {
        Node save = first;
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        while (save != last) {
            System.out.print(save.value + "-->");
            save = save.link;
        }
        System.out.print(save.value + "-->Last");
        System.out.println("");
    }

    public int sizeOfCircularLinkedList() {
        if (first == null) {
            return 0;
        }
        Node save = first;
        int count = 0;
        do {
            count++;
            save = save.link;
        } while (save != first);

        return count;
    }
}

public class CountNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        boolean isEnd = true;
        int value = 0;
        int element = 0;

        while (isEnd) {
            System.out.println("Enter 1 to enter the element and 0 to terminate:");
            value = sc.nextInt();
            switch (value) {
                case 1:
                    element = sc.nextInt();
                    list.cirInsertAtFirst(element);
                    break;
                case 0:
                    isEnd = false;
                    break;

                default:
                    System.out.println("Invalid input. Please enter 1 or 0.");
                    break;
            }
        }
        sc.close();
        list.display();
        System.out.println("Number of nodes present in circular LinkedList are:" + list.sizeOfCircularLinkedList());
    }
}
