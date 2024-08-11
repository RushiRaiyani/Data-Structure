// Write a program to implement queue using singly linked list.

package LinkedListImplementation;

import java.util.Scanner;

class LinkedList {
    class Node {
        int value;
        Node link;

        public Node(int value) {
            this.value = value;
            this.link = null;
        }
    }

    Node first = null;

    public void push(int value) {
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
            System.out.println("Stack is empty");
        } else {
            while (save != null) {
                System.out.print(save.value + " ");
                save = save.link;
            }
            System.out.println("");
        }
    }

    public int pop() {
        int ans = 0;
        if (first == null) {
            return -1;
        } else {
            ans = first.value;
            first = first.link;
        }
        return ans;
    }
}

public class QueueAsLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         LinkedList queue = new LinkedList();
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("Enter 1 to enter the element ");
            System.out.println("Enter 2 to pop the element");
            System.out.println("Enter 3 to Display the elements");
            System.out.println("Enter 0 to terminate:");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    int element = sc.nextInt();
                    queue.push(element);
                    break;
                case 2:
                    int popped = queue.pop();
                    if (popped == -1) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Popped element is: " + popped);
                    }
                    break;
                case 3:
                    queue.display();
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
