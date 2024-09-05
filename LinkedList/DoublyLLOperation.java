// Write a menu driven program to implement following operations on the doubly 
// linked list.
// 1. Insert a node at the front of the linked list.
// 2. Delete a node from specified position.
// 3. Insert a node at the end of the linked list.
// 4. Display all nodes.
package DoublyLinkedList;

import java.util.Scanner;

class DoublyLL {
    Node Left;
    Node Right;

    public DoublyLL() {
        this.Left = null;
        this.Right = null;
    }

    class Node {
        int value;
        Node lpter, rpter;

        public Node(int value) {
            this.value = value;
            this.lpter = null;
            this.rpter = null;
        }
    }

    void insAtFirst(int value) {
        Node newNode = new Node(value);
        if (Left == null) {
            Left = newNode;
            Right = newNode;
            return;
        }
        newNode.rpter = Left;
        Left.lpter = newNode;
        Left = newNode;
    }

    public void insAtLast(int value) {
        Node newNode = new Node(value);
        if (Left == null) {
            Left = newNode;
            Right = newNode;
            return;
        }
        Right.rpter = newNode;
        newNode.lpter = Right;
        Right = newNode;
    }

    public void display() {
        if (Left == null) {
            System.out.println("Linked list is empty");
        } else {
            Node temp = Left;
            while (temp != null) {
                System.out.print(temp.value + " <-> ");
                temp = temp.rpter;
            }
            System.out.println("null");
        }
    }

    public void delete(int value) {
        if (Left == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = Left;
        if (Left.value == value) {
            if (Left == Right) {
                Left = null;
                Right = null;
            } else {
                Left = Left.rpter;
                Left.lpter = null;
            }
            return;
        }
        if (Right.value == value) {
            Right = Right.lpter;
            Right.rpter = null;
            return;
        }
        System.out.println("h");
        while (temp != null && temp.value != value) {
            temp = temp.rpter;
        }
        System.out.println("i");
        if (temp == null) {
            System.out.println("Element not found");
            return;
        }
        System.out.println("a");
        temp.lpter.rpter = temp.rpter;
        if (temp.rpter != null) {
            temp.rpter.lpter = temp.lpter;
        }
    }
}

public class DoublyLLOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLL dll = new DoublyLL();
        boolean isbreak = true;
        while (isbreak) {
            System.out.println("Enter 1 to Add node at First position");
            System.out.println("Enter 2 to Add node at Last position");
            System.out.println("Enter 3 to delete element from LinkedList");
            System.out.println("Enter 4 to Display LinkedList");
            System.out.println("Enter 5 to exit:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the value to insert at first:");
                    int value1 = sc.nextInt();
                    dll.insAtFirst(value1);
                    break;
                case 2:
                    System.out.println("Enter the value to insert at last:");
                    int value2 = sc.nextInt();
                    dll.insAtLast(value2);
                    break;
                case 3:
                    System.out.println("Enter the value to delete:");
                    int valueToDelete = sc.nextInt();
                    dll.delete(valueToDelete);
                    break;
                case 4:
                    dll.display();
                    break;
                case 5:
                    isbreak = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        sc.close();
    }
}
