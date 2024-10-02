// Write a program to implement a Linear Search using Array.
package Sorting_Searching;

import java.util.Scanner;

class Searching {
    Scanner sc = new Scanner(System.in);
    int arr[];

    public Searching(int n) {
        this.arr = new int[n];
    }

    public int linear(int searchElement) {
        for (int i = 0; i < arr.length; i++) {
            if (searchElement == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public void getArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter element at index " + i);
            arr[i] = sc.nextInt();
        }
    }
}

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        Searching sr = new Searching(n);
        sr.getArray();
        System.out.println("Enter element to search:");
        int searchElement = sc.nextInt();
        int ans = sr.linear(searchElement);
        System.out.println("Element " + searchElement + " found at " + ans);
        sc.close();
    }
}