// WAP to split a circular linked list into two halves.
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

    public void splitList(CirLinkedList list2) {
        int count = sizeOfCircularLinkedList();
        Node save = first;
        int flag = 0;
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        if (first == last) {
            return;
        }
        int a = 0;
        if (count % 2 == 0) {
            a = count / 2 - 1;
        } else {
            a = count / 2;
        }
        while (flag != a) {
            save = save.link;
            flag++;
        }
        list2.first = save.link;
        list2.last = last;
        list2.last.link = list2.first;
        save.link = first;
        last = save;
    }

}

public class SplitLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CirLinkedList cirLL = new CirLinkedList();
        CirLinkedList cirLL2 = new CirLinkedList();

        System.out.println("Please Enter 1 if you want to insert a node at 1st position in LL,");
        System.out.println("Please Enter 2 if you want to Display your linkedLIst,");
        System.out.println("Please Enter 3 if you want to exit the process");

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
                    cirLL.display();
                    break;
                case 3:
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
        cirLL.splitList(cirLL2);
        System.out.println("First Half:");
        cirLL.display();
        System.out.println("Second Half:");
        cirLL2.display();
        sc.close();
    }
}
