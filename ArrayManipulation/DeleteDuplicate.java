// Write a program to delete duplicate numbers from an array.

import java.util.Arrays;
import java.util.Scanner;

public class DeleteDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int arr[] = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter element at " + (i + 1));
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int k = arr.length - 1;
        int m = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i] == arr[j] && i != j) {
                    arr[j] = arr[k];
                    arr[k] = 0;
                    k--;
                    m--;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
