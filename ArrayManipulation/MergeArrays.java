// Write a program to merge two unsorted arrays

import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first array:");
        int arr1[] = new int[sc.nextInt()];
        System.out.println("Enter the size of second array:");
        int arr2[] = new int[sc.nextInt()];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Enter element at " + (i + 1) + " for arr1");
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Enter element at " + (i + 1) + " for arr2");
            arr2[i] = sc.nextInt();
        }
        int arr3[] = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
            } else {
                arr3[i] = arr2[i - arr1.length];
            }
        }
        System.out.println("Merged array is:");
        for (int i = 0; i < arr3.length; i++) {
            System.out.println("element at " + (i + 1) + " is " + arr3[i]);
        }
        sc.close();
    }
}
