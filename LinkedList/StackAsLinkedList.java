// Write a program to implement stack using singly linked list.
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
        int popped = 0;
        if (first == null) {
            System.out.println("Stack underflow");
        } else {
            popped = first.value;
            first = first.link;
        }
        return popped;
    }

    public void change(int value, int nodeIndex) {
        Node save = first;
        int count = 1;
        if (save == null) {
            System.out.println("Stack underflow");
            return;
        } else if (nodeIndex == 1 && save.link == null) {
            save.value = value;
            return;
        }
        while (count != nodeIndex) {
            if (save.link == null) {
                System.out.println("Index out of range");
                return;
            }
            save = save.link;
            count++;
        }
        save.value = value;
    }

    public int peep(int index) {
        Node save = first;
        int count = 1;
        int ans = 0;
        if (save == null) {
            return 0;
        }
        if (index == 1) {
            first = first.link;
            return save.value;
        } else {
            while (count != index - 1) {
                if (save.link == null) {
                    return -1;
                }
                save = save.link;
                count++;
            }
            if (save.link == null) {
                return -1; // Index out of range
            }

            ans = save.link.value;

            if (save.link.link != null) {
                save.link = save.link.link;
            } else {
                save.link = null;
            }
        }
        return ans;
    }
}

public class StackAsLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList stack = new LinkedList();
        boolean isbreak = true;
        while (isbreak) {
            System.out.println("Enter 1 to perform push operation:");
            System.out.println("Enter 2 to perform pop operation:");
            System.out.println("Enter 3 to display the stack:");
            System.out.println("Enter 4 to change the value of node:");
            System.out.println("Enter 5 to peep the top element:");
            System.out.println("Enter 6 to exit:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to push:");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int popped = stack.pop();
                    System.out.println("Popped element is:" + popped);
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Enter the value to change:");
                    int changeValue = sc.nextInt();
                    System.out.println("Enter the node index:");
                    int changeIndex = sc.nextInt();
                    stack.change(changeValue, changeIndex);
                    break;
                case 5:
                    System.out.println("Enter element index to remove:");
                    int index = sc.nextInt();
                    int peeped = stack.peep(index);
                    if (peeped == 0) {
                        System.out.println("Stack underflow");
                    } else if (peeped == -1) {
                        System.out.println("Index out of range");
                    } else {
                        System.out.println("element peeped is:" + peeped);
                    }
                    break;
                case 6:
                    isbreak = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
