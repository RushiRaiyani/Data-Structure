// Write a menu driven program to implement following operations on the Queue 
// using an Array
// 1. ENQUEUE
// 2. DEQUEUE
// 3. DISPLAY
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

    public void enQueue(int value) {
        if (rear == -1) {
            front = 0;
        }
        if (rear >= n - 1) {
            System.out.println("Queue Overflow");
        } else {
            rear++;
            arr[rear] = value;
        }
    }

    public int deQueue() {
        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            int ans = arr[front];
            if (front == rear) {
                front = -1;
                rear = -1;
                System.out.println("Queue Empty");
            } else {
                front++;
            }
            return ans;
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue Underflow");
        } else if (front >= n) {
            System.out.println("Queue Empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }

    }
}

public class QueueMenuDriven {
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
                queue.enQueue(value);
            } else if (choice == 2) {
                int dequeued = queue.deQueue();
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
