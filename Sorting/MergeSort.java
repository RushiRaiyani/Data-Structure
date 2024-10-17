// Write a program to implement Merge Sort using Array.
package Sorting_Searching;

import java.util.Scanner;

class MySorting {

    int arr[];

    public void mergeSorting(int low, int high) {
        if (low < high) {   
            double mid = Math.floor((low + high) / 2);
            mergeSorting(low, (int) mid);
            mergeSorting((int) mid + 1, high);
            merge(low, (int) mid, high);
        }
        return;
    }

    public void merge(int low, int mid, int high) {
        int[] b = new int[high - low + 1];
        int h = low;
        int i = 0;
        int j = mid + 1;
        while (h <= mid && j <= high) {
            if (arr[h] <= arr[j]) {
                b[i] = arr[h];
                h++;
            } else {
                b[i] = arr[j];
                j++;
            }
            i++;
        }
        if (h > mid) {
            for (int k = j; k <= high; k++) {
                b[i] = arr[k];
                i++;
            }
        } else {
            for (int k = h; k <= mid; k++) {
                b[i] = arr[k];
                i++;
            }
        }
        for (int k = 0; k < b.length; k++) {
            arr[low + k] = b[k];
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

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms:");
        int n = sc.nextInt();

        MySorting ms = new MySorting();
        ms.getArray(n);
        ms.mergeSorting(0, n - 1);
        ms.display(ms.arr);
    }
}
