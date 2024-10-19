// Write a program to implement Counting Sort using Array.
package Sorting_Searching;

import java.util.Scanner;

class MySorting {
    int b[];

    public void CountingSorting(int arr[], int max) {
        int c[] = new int[max];
        b = new int[arr.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        for (int j = 0; j < arr.length; j++) {
            c[arr[j] - 1] = c[arr[j] - 1] + 1;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = c[arr[i] - 1] - 1;
            b[value] = arr[i];
        }
    }

    public void display() {
        System.out.println("Sorted Array is: ");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i] + " ");
        }
    }
}

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms in array:");
        int n = sc.nextInt();
        MySorting sorting = new MySorting();
        int arr[] = new int[n];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter number at index [" + i + "]: ");
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        sorting.CountingSorting(arr, max);
        sorting.display();
        sc.close();
    }
}
