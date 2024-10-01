// Write a menu driven program to implement following operations on a circular 
// queue using an Array
// 1. Insert
// 2. Delete
// 3. Display all elements of the queue
package Queue;

import java.util.Scanner;

class MyQueue {
    int arr[];
    int n = 0;

    MyQueue(int n) {
        this.arr = new int[n];
        this.n = n;
    }

    int front = -1, rear = -1;

    public void cEQueue(int value) {
        if ((rear + 1) % n == front) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % n;
        arr[rear] = value;
    }

    public int cDeQueue() {
        if (rear == -1 && front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int ans = arr[front];
        if (front == rear) {
            front = rear = -1;
        }
        front = (front + 1) % n;
        return ans;
    }

    public void display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue Underflow");
        } else {
            int i = front;
            while (i < rear) {
                System.out.print(arr[i] + " ");
                i = (i + 1) % n;
            }
            System.out.print(arr[rear]);
            System.out.println("");
        }
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Array:");
        int n = sc.nextInt();
        MyQueue queue = new MyQueue(n);
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("Enter 1 to add element to queue");
            System.out.println("Enter 2 to remove element from queue");
            System.out.println("Enter 3 to display queue");
            System.out.println("Enter 4 to exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter element to enqueue:");
                int value = sc.nextInt();
                queue.cEQueue(value);
            } else if (choice == 2) {
                int dequeued = queue.cDeQueue();
                if (dequeued != -1) {
                    System.out.println("Dequeued element is: " + dequeued);
                }
            } else if (choice == 3) {
                queue.display();
            } else if (choice == 4) {
                isEnd = false;
            } else {
                System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
