package Sorting_Searching;

import java.util.Scanner;

class MySorting {
    public void RadixSorting(int arr[]) {
        
    }

    public void display(int arr[]) {
        System.out.println("Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

public class RadixSort {
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
        sorting.RadixSorting(arr);
        sorting.display(arr);
        sc.close();
    }
}
