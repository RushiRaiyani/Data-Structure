// Write a program to implement Quick Sort using Array.
package Sorting_Searching;

import java.util.Scanner;

class MySorting {
    int arr[];

    public void quickSorting(int lb, int up) {
        boolean isFound = true;
        if (lb < up) {
            int i = lb;
            int j = up + 1;
            int key = arr[lb];
            while (isFound) {
                i++;
                while (arr[i] < 
                key) {
                    i++;
                }
                j--;
                while (arr[j] > key) {
                    j--;
                }
                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                } else {
                    isFound = false;
                }
            }
            int temp = arr[j];
            arr[j] = arr[lb];
            arr[lb] = temp;
            quickSorting(lb, j - 1);
            quickSorting(j + 1, up);
 
        }
    }

    public void getArray(int n) {
        arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }
    }

    public void display(int arr[]) {
        System.out.println("Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms:");
        int n = sc.nextInt();

        MySorting sort = new MySorting();
        sort.getArray(n);
        sort.quickSorting(0, n - 1);
        sort.display(sort.arr);
    }
}
