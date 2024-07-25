// Given a set of time intervals in any order, our task is to merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.

import java.util.Scanner;

class MyStack {
    int arr[][];

    public MyStack(int n) {
        this.arr = new int[n][2];
    }

    int top = -1;

    // push
    public void push(int number1, int number2) {

        if (top >= arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        } else {
            top++;
            arr[top][0] = number1;
            arr[top][1] = number2;
            System.out.println("Element is pushed successfully");
            return;
        }
    }

    public void reverse() {
        for (int i = 0; i < arr.length; i++) {
            int[] popped = pop();
            push(popped[0], popped[1]);
        }
    }

    // pop
    public int[] pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            int[] poppedInterval = new int[2];
            poppedInterval[0] = arr[top][0];
            poppedInterval[1] = arr[top][1];
            top--;
            return poppedInterval;
        }
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }

    public void setInterval(MyStack select2) {
        if (top == -1) {
            System.out.println("No intervals to merge");
            return;
        }
        int popped1[];
        int popped2[];
        popped1 = pop();
        while (top != -1) {
            popped2 = pop();
            if ((popped1[0] <= popped2[0] && popped1[1] >= popped2[0])
                    || (popped1[0] <= popped2[1] && popped1[1] >= popped2[1])
                    || (popped2[0] <= popped1[0] && popped2[1] >= popped1[0])
                    || popped2[0] <= popped1[1] && popped2[1] >= popped1[1]) {
                int start1 = Math.min(popped1[0], popped1[1]);
                int end1 = Math.max(popped1[0], popped1[1]);
                int start2 = Math.min(popped2[0], popped2[1]);
                int end2 = Math.max(popped2[0], popped2[1]);
                int start = Math.min(start1, start2);
                int end = Math.max(end1, end2);
                popped1[0] = start;
                popped1[1] = end;
            } else {
                select2.push(popped1[0], popped1[1]);
                popped1 = popped2;
            }
        }
        select2.push(popped1[0], popped1[1]);
    }
}

public class OverlapInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        MyStack select = new MyStack(n);
        MyStack select2 = new MyStack(n);
        boolean isStop = true;
        while (isStop == true) {
            System.out.println(
                    "Enter method of stack from push,pop,display which should be perform: and enter leave to exit:");
            String take = sc.next();
            take = take.toLowerCase();
            switch (take) {
                case "push":
                    System.out.println("Enter the interval 1:");
                    int number = sc.nextInt();
                    int number2 = sc.nextInt();
                    select.push(number, number2);
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
        select.setInterval(select2);
        select2.display();
        sc.close();
    }
}
