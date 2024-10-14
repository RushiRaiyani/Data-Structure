// Write a program to implement Bubble using Array.
package Sorting_Searching;

import java.util.Scanner;

class MySorting {
    public void BubbleSorting(int arr[]) {
        boolean isDone = false;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isDone = true;
                }
            }
            if (isDone == false) {
                break;
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

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        MySorting sort = new MySorting();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element at index [" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        sort.BubbleSorting(arr);
        sort.display(arr);
        sc.close();
    }
}
