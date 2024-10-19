// Write a program to implement Shell Sort using Array.
package Sorting_Searching;

import java.util.Scanner;

class MySorting {
    public void ShellSorting(int arr[]) {
        for (int gap = arr.length / 2; gap >= 1; gap = gap / 2) {
            for (int j = gap; j < arr.length; j++) {
                for (int i = j - gap; i >= 0; i = i - gap) {
                    if (arr[i + gap] > arr[i]) {
                        break;
                    } else {
                        int temp = arr[i + gap];
                        arr[i + gap] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
    }

    public void display(int arr[]) {
        System.out.println("Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

public class ShellSort {
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
        sorting.ShellSorting(arr);
        sorting.display(arr);
        sc.close();
    }
}
