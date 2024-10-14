// Write a program to implement Insertion Sort using Array.
package Sorting_Searching;

import java.util.Scanner;

class MySorting {
    public void InsertionSorting(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void display(int arr[]) {
        System.out.println("Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms in array:");
        int n = sc.nextInt();
        MySorting sorting = new MySorting();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter number at index [" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        sorting.InsertionSorting(arr);
        sorting.display(arr);
        sc.close();
    }
}
