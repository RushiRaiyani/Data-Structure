// WAP to swap Kth node from beginning with Kth node from end in a singly linked list.
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

    public void swap(int n) {
        if (n <= 0 || n > countNodes() || first.link == null) {
            System.out.println("Invalid position");
            return;
        }
        Node save = first;
        Node prev = first;
        Node start = null;
        int count = 1;
        int lastCount = countNodes() - n;
        if (n == lastCount + 1 || countNodes() == 1) {
            return;
        }
        if (countNodes() == 2) {
            prev = prev.link;
            first = prev;
            prev.link = save;
            save.link = null;
            return;
        }
        while (count != n) {
            start = prev;
            prev = prev.link;
            count++;
        }
        count = 1;
        while (count != lastCount) {
            save = save.link;
            count++;
        }
        if (n == 1) {
            // when 1st node is to be swapped
            Node temp = save.link;
            temp.link = prev.link;
            save.link = prev;
            prev.link = null;
            first = temp;
        } else {
            // if 6 nodes are taken as input and 3node should be swapped then here save and
            // prev will same,in that case
            if (prev == save) {
                Node temp = save.link;
                prev.link = temp.link;
                temp.link = prev;
                start.link = temp;
                return;
            }
            Node temp = save.link;
            save.link = temp.link;
            temp.link = prev.link;
            start.link = temp;
            prev.link = save.link;
            save.link = prev;
        }
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

public class SwapNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("Enter 1 to enter the element and 0 to terminate:");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    int element = sc.nextInt();
                    list.insertAtFirst(element);
                    break;
                case 0:
                    isEnd = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 0.");
                    break;
            }
        }
        System.out.println("Enter the position of the node to swap:");
        int n = sc.nextInt();
        list.swap(n);
        list.display();
        sc.close();
    }
}
