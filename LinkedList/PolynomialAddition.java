// Write a program to perform addition of two polynomial equations using 
// appropriate data structure.
package LinkedList;

import java.util.Scanner;

public class PolynomialAddition {
    class Node {
        int value;
        int coValue;
        char constants;
        Node link;

        public Node(int value, int coValue, char constants) {
            this.value = value;
            this.coValue = coValue;
            this.constants = constants;
            this.link = null;
        }
    }

    Node first = null;

    public void insertAtFirst(int value, int coValue, char name) {
        Node newNode = new Node(value, coValue, name);
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
                System.out.print(save.coValue + save.constants + "^" + save.value + "+");
                save = save.link;
            }
            System.out.println("0");
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

    public void merge(PolynomialAddition list2) {
        Node save = first;
        if (first == null) {
            first = list2.first;
            return;
        }
        while (save.link != null) {
            save = save.link;
        }
        save.link = list2.first;
    }

    public void checkDuplicate() {
        Node save = first;
        while (save != null && save.link != null) {
            Node prev = save;
            Node temp = save.link;
            while (temp != null) {
                if (save.value == temp.value && save.constants == temp.constants) {
                    prev.link = temp.link;
                    temp = prev.link;
                } else {
                    prev = temp;
                    temp = temp.link;
                }
            }
            save = save.link;
        }
    }

    public void addPolynomial() {
        int count = countNodes();
        Node save = first;
        Node temp = save.link;
        int flag = 0;
        while (flag != count) {
            temp = save.link;
            while (temp != null) {
                if (save.value == temp.value && save.constants == temp.constants) {
                    save.coValue = save.coValue + temp.coValue;
                }
                temp = temp.link;
            }
            flag++;
            save = save.link;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PolynomialAddition list1 = new PolynomialAddition();
        PolynomialAddition list2 = new PolynomialAddition();
        System.out.println("Enter the elements of list1:");
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("Enter 1 to enter the element and 0 to terminate:");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    System.out.println("Enter it's co-efficient:");
                    System.out.println("Enter variable name");
                    System.out.println("Enter power of variable:");
                    int coValue = sc.nextInt();
                    char name = sc.next().charAt(0);
                    int power = sc.nextInt();

                    list1.insertAtFirst(power, coValue, name);
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
                    System.out.println("Enter it's co-efficient:");
                    System.out.println("Enter variable name");
                    System.out.println("Enter power of variable:");
                    int coValue = sc.nextInt();
                    char name = sc.next().charAt(0);
                    int power = sc.nextInt();

                    list2.insertAtFirst(power, coValue, name);
                    break;
                case 0:
                    isEnd = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 0.");
                    break;
            }
        }

        list1.merge(list2);
        list1.addPolynomial();
        list1.checkDuplicate();
        list1.display();
        sc.close();
    }
}