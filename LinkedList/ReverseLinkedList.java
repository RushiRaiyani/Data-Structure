// Write a program to reverse a linked list.
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

    public void reverse() {
        Node save = first;
        Node temp = first;
        Node prev = null;
        while (temp != null) {
            temp = save.link;
            save.link = prev;
            prev = save;
            save = temp;

        }
    }

}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list1 = new MyLinkedList();
        System.out.println("Enter the elements of list1:");
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("Enter 1 to enter the element and 0 to terminate:");
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
        sc.close();
    }
}
