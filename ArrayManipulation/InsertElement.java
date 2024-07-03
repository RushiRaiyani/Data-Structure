// Write a program to insert a number at a given location in an array.

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int arr1[] = new int[sc.nextInt()];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Enter element at " + (i + 1));
            arr1[i] = sc.nextInt();
        }
        int arr2[] = new int[arr1.length + 1];
        System.out.println("Enter element and index where it should be entered:");
        int element = sc.nextInt();
        int index = sc.nextInt();
        int k = 0;
        if (index > arr1.length + 1) {
            System.out.println("Invalid index");
        }
        for (int i = 0; i < arr2.length; i++) {
            if (index == i) {
                arr2[i] = element;
            } else {
                arr2[i] = arr1[k];
                k++;
            }
        }
        System.out.println("final array:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        sc.close();
    }
}