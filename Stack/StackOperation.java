
// Write a menu driven program to implement following operations on the Stack 
// using an Array
// PUSH, POP, DISPLAY
// PEEP, CHANGE
import java.util.Scanner;
import java.util.Stack;

class MyStack {
    int arr[];

    public MyStack(int[] arr, int n) {
        this.arr = new int[n];
    }

    int top = -1;

    // push
    public void push(int number) {
        // checking if array is fully filled or not
        if (top >= arr.length - 1) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            arr[top] = number;
            System.out.println("Element is pushed successfully");
        }
    }

    // pop
    public int pop() {
        // empty stack
        if (top == -1) {
            return -1;
        } else {
            top--;
            return arr[top + 1];
        }
    }

    // peep
    public int peep(int index) {
        if (top - index + 1 < 0 || index <= 0) {
            return -1;
        } else {
            return arr[top - index + 1];
        }
    }

    // change
    public void change(int index, int a) {
        if (top - index + 1 <= 0 || index <= 0) {
            System.out.println("Invalid Index");
        } else {
            arr[top - index + 1] = a;
            return;
        }
    }

    // display
    public void display() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return;
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        return;
    }
}

public class StackOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        MyStack select = new MyStack(arr, n);
        boolean isStop = true;
        while (isStop == true) {
            System.out.println(
                    "Enter method of stack from push,pop,peep,change,display which should be perform: and enter leave to exit:");
            String take = sc.next();
            take = take.toLowerCase();
            switch (take) {
                case "push":
                    System.out.println("Enter the number to push:");
                    int number = sc.nextInt();
                    select.push(number);
                    break;
                case "pop":
                    int popped = select.pop();
                    if (popped == -1) {
                        System.out.println("Stack underflow");
                    } else {
                        System.out.println("Popped element is: " + popped);
                    }
                    break;
                case "peep":
                    System.out.println("Enter the index to see the element:");
                    int index = sc.nextInt();
                    int peeped = select.peep(index);
                    if (peeped == -1) {
                        System.out.println("Stack underflow");
                    } else {
                        System.out.println("Pepped element is: " + peeped);
                    }
                    break;
                case "change":
                    System.out.println("Enter the index and the number to change:");
                    index = sc.nextInt();
                    int change_number = sc.nextInt();
                    select.change(index, change_number);
                    System.out.println("element changed successfully");
                    break;
                case "display":
                    select.display();
                    break;
                case "leave":
                    isStop = false;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
        sc.close();
    }
}