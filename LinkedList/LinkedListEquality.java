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

    public void checkEquality(MyLinkedList list2) {
        Node save1 = first;
        Node save2 = list2.first;
        boolean isEqual = true;
        while (save1 != null && save2 != null) {
            System.out.println(save1.value + " " + save2.value);
            if (save1.value != save2.value) {
                System.out.println("1");
                isEqual = false;
                break;
            }
            save1 = save1.link;
            save2 = save2.link;
        }
        if (isEqual) {
            System.out.println("The two linked lists are equal");
        } else {
            System.out.println("The two linked lists are not equal");
        }
    }
}

public class LinkedListEquality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
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
        System.out.println("Enter the elements of list1:");
        isEnd = true;

        while (isEnd) {
            System.out.println("Enter 1 to enter the element and 0 to terminate:");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    int element = sc.nextInt();
                    list2.insertAtFirst(element);
                    break;
                case 0:
                    isEnd = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 0.");
                    break;
            }
        }
        list1.checkEquality(list2);
        sc.close();
    }
}