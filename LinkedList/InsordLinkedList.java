package LinkedList;

import java.util.Scanner;

class MyLinkedList {
    class Node {
        int value;
        Node link;

        public Node(int data) {
            this.value = data;
            this.link = null;
        }
    }

    Node first = null;

    public void insord(int data) {
        Node newNode = new Node(data);
        Node save = first;
        if (first == null || newNode.value <= first.value) {
            first = newNode;
        } else {
            while (save.link != null && newNode.value >= save.link.value) {
                save = save.link;
            }
            newNode.link = save.link;
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
}

public class InsordLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        boolean isOut = true;
        while (isOut) {
            System.out.println("Enter 1 to insert element in Linked List");
            System.out.println("Enter 2 to display elements in Linked List");
            System.out.println("Enter 3 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to enter in linked list");
                    int n = sc.nextInt();
                    list.insord(n);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    isOut = false;
                    break;
                default:
                    System.out.println("Enter correct choice");
            }
        }
        sc.close();
    }
}
