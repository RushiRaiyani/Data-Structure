// Write a program to implement Bubble using Array.
package Sorting_Searching;

import java.util.Scanner;

class MySorting {
    public void SelectionSorting(int arr[]) {
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public void display(int arr[]) {
        System.out.println("Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element at index [" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        MySorting sort = new MySorting();
        sort.SelectionSorting(arr);
        sort.display(arr);
        sc.close();
    }
}
