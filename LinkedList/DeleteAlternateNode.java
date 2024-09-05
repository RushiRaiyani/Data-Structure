// WAP to delete alternate nodes of a doubly linked list.
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

    public void deleteAlternate() {
        int count = 1;
        Node save = Left;
        Node temp = Left;
        if (Left == Right || Left == null) {
            return;
        }
        if (Left.rpter == Right) {
            Left.rpter = null;
            Right = Left;
            return;
        }
        while (save != null) {
            if (count % 2 == 0) {
                if (save.rpter == null) {
                    save.lpter.rpter = null;
                    return;
                }
                temp = save.rpter;
                save.lpter.rpter = temp;
                temp.lpter = save;
                save = temp;
            } else {
                save = save.rpter;
                temp = save;
            }
            count++;
        }
    }
}

public class DeleteAlternateNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLL dll = new DoublyLL();
        boolean isbreak = true;
        while (isbreak) {
            System.out.println("Enter 1 to Add node at First position");
            System.out.println("Enter 2 to Display LinkedList");
            System.out.println("Enter 3 to exit:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the value to insert at first:");
                    int value1 = sc.nextInt();
                    dll.insAtFirst(value1);
                    break;
                case 2:
                    dll.display();
                    break;
                case 3:
                    isbreak = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        dll.deleteAlternate();
        System.out.println("Doubly Linked List after Deleting Alternate Nodes is:");
        dll.display();
        sc.close();
    }
}
