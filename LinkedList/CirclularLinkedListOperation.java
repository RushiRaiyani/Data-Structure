// Write a menu driven program to implement following operations on the 
// circular linked list.
// 1. Insert a node at the front of the linked list.
// 2. Delete a node from specified position.
// 3. Insert a node at the end of the linked list.
// 4. Display all nodes.
package CircularLinkedList;

import java.util.Scanner;

class CirLinkedList {
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

    public void cirInsertAtLast(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = last = newNode;
            newNode.link = first;
            return;
        }
        newNode.link = first;
        last.link = newNode;
        last = newNode;
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

    public void delete(int value) {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node save = first;
        Node prev = null;
        if (first.value == value) {
            // When only one Node is present in Linked List
            if (first == last) {
                first = last = null;
                System.out.println("Node deleted Successfully");
                return;
            }
            // When more than one Node is present in Linked List
            first = first.link;
            last.link = first;
            System.out.println("Node deleted Successfully");
            return;
        }
        while (save != last && save.value != value) {
            prev = save;
            save = save.link;
        }
        if (save.value != value) {
            System.out.println("Node you want to delete does not found");
            return;
        }
        prev.link = save.link;
        if (save == last) {
            last = prev;
            prev.link = first;
            return;
        }
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

public class CirclularLinkedListOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CirLinkedList cirLL = new CirLinkedList();

        System.out.println("Please Enter 1 if you want to insert a node at 1st position in LL,");
        System.out.println("Please Enter 2 if you want to insert a node at last position in LL,");
        System.out.println("Please Enter 3 if you want to delete a node from any position in LL,");
        System.out.println("Please Enter 4 if you want to Display your linkedLIst,");
        System.out.println("Please Enter 5 if you want to get the size of linked list,");
        System.out.println("Please Enter 6 if you want to exit the process");

        boolean isTheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the number to be inserted at first:");
                    int num1 = sc.nextInt();
                    cirLL.cirInsertAtFirst(num1);
                    break;
                case 2:
                    System.out.println("Enter the number to be inserted at last:");
                    int num2 = sc.nextInt();
                    cirLL.cirInsertAtLast(num2);
                    break;
                case 3:
                    System.out.println("Enter the node to be deleted:");
                    int pos = sc.nextInt();
                    cirLL.delete(pos);
                    break;
                case 4:
                    cirLL.display();
                    break;
                case 5:
                    System.out.println("Size of Circular LL :" + cirLL.sizeOfCircularLinkedList());
                    break;
                case 6:
                    System.out.println("Exiting the process");
                    isTheEnd = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (isTheEnd) {
                break;
            }
        }
        sc.close();
    }
}
