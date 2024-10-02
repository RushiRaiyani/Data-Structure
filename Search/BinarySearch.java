// Write a program to implement a Binary Search using Array.
package Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

class Searching {
    Scanner sc = new Scanner(System.in);
    int arr[];

    public Searching(int n) {
        this.arr = new int[n];
    }

    public void getArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter element at index " + i);
            arr[i] = sc.nextInt();
        }
    }

    public int binary(int searchElement) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        Arrays.sort(arr);
        boolean isFound = false;
        while (right >= left) {
            mid = (left + right) / 2;
            if (searchElement == arr[mid]) {
                isFound = true;
                break;
            } else if (searchElement < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (!isFound) {
            return -1;
        } else {
            return mid;
        }
    }

}

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        Searching sr = new Searching(n);
        sr.getArray();
        System.out.println("Enter element to search:");
        int searchElement = sc.nextInt();
        int ans = sr.binary(searchElement);
        if (ans != -1) {
            System.out.println("The index of " + searchElement + "is=" + ans);
        } else {
            System.out.println("Index not found");
        }
        sc.close();
    }
}
