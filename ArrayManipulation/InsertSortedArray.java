// Write a program to insert a number in an array that is already sorted in an 
// ascending order.

import java.util.Scanner;

public class InsertSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int arr1[] = new int[sc.nextInt()];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Enter element at " + (i + 1));
            arr1[i] = sc.nextInt();
        }
        int arr2[] = new int[arr1.length + 1];
        System.out.println("Enter element:");
        int element = sc.nextInt();
        int k = 0;
        boolean isFound = false;
        for (int i = 0; i < arr2.length; i++) {
            if (element < arr1[k] && !isFound) {
                arr2[i] = element;
                isFound = true;
            } else {
                arr2[i] = arr1[k];
                k++;
            }
        }
        System.out.println("New array will be:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        sc.close();
    }
}
