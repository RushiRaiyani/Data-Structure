// Write a menu driven program to implement following operations on the singly 
// linked list. 
// 1. Insert a node at the front of the linked list.
// 2. Display all nodes.
// 3. Delete a first node of the linked list.
// 4. Insert a node at the end of the linked list.
// 5. Delete a last node of the linked list.
// 6. Delete a node from specified position.

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

    public void deleteAtFirst() {
        if (first == null) {
            System.out.println("Linked List is empty");
        } else {
            first = first.link;
        }
    }

    public void deleteLastNode() {
        Node save = first;
        if (save == null) {
            System.out.println("Linked List is empty");
        } else {
            while (save.link.link != null) {
                save = save.link;
            }
            save.link = null;
        }
    }

    public void deleteSpecificNode(int value) {
        Node save = first, prev = null;
        if (save.value == value) {
            first = first.link;
            return;
        }
        while (save != null && save.value != value) {
            prev = save;
            save = save.link;
        }
        if (save == null) {
            System.out.println("Element you want to delete does not found");
            return;
        }
        prev.link = save.link;
    }

    public void insertSpecificNode(int value, int nodeIndex) {
        Node newNode = new Node(value);
        Node save = first;
        int count = 1;
        if (nodeIndex == 1) {
            first = newNode;
            first.link = save;
            return;
        }
        if (save == null) {
            if (count == 1) {
                first = newNode;
                return;
            } else {
                System.out.println("Empty LinkedList");
            }
        }
        while (count != nodeIndex - 1) {
            if (save.link == null) {
                System.out.println("Node Index out of range");
                return;
            }
            save = save.link;
            count++;
        }
        newNode.link = save.link;
        save.link = newNode;
    }

    public int countNodes() {
        int count = 0;
        Node save = first;
        while (save != null) {
            count++;
            save = save.link;
        }
        return count;
    }

}

public class LinkedListOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        boolean isbreak = true;
        while (isbreak) {
            System.out.println("Enter 1 to Add node at First position");
            System.out.println("Enter 2 to Add node at Last position");
            System.out.println("Enter 3 to delete node at First position");
            System.out.println("Enter 4 to delete node at Last position");
            System.out.println("Enter 5 to Display LinkedList");
            System.out.println("Enter 6 to delete element from LinkedList");
            System.out.println("Enter 7 to add element at specific place in LinkedList");
            System.out.println("Enter 8 to count total number of nodes");
            System.out.println("Enter 9 to exit:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the value to insert at first:");
                    int value1 = sc.nextInt();
                    list.insertAtFirst(value1);
                    break;
                case 2:
                    System.out.println("Enter the value to insert at last:");
                    int value2 = sc.nextInt();
                    list.insertAtLast(value2);
                    break;
                case 3:
                    list.deleteAtFirst();
                    break;
                case 4:
                    list.deleteLastNode();
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Enter the value to delete:");
                    int valueToDelete = sc.nextInt();
                    list.deleteSpecificNode(valueToDelete);
                    break;
                case 7:
                    System.out.println("Enter the value to insert and node index:");
                    int valueToInsert = sc.nextInt();
                    int nodeIndex = sc.nextInt();
                    list.insertSpecificNode(valueToInsert, nodeIndex);
                    break;
                case 8:
                    int totalNodes = list.countNodes();
                    System.out.println("Total number of nodes in LinkedList: " + totalNodes);
                    break;
                case 9:
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
