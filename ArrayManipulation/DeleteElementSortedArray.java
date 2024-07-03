// Write a program to delete a number from an array that is already sorted in an 
// ascending order.

import java.util.Scanner;

public class DeleteElementSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int arr1[] = new int[sc.nextInt()];
        int arr2[] = new int[arr1.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Enter element at " + (i + 1));
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter element which should be deleted:");
        int element = sc.nextInt();
        int k = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == element) {
                continue;
            } else {
                arr2[k] = arr1[i];
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
