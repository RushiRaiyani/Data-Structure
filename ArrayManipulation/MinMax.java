
/* Write a program to find position of the smallest number & the largest number
from given n numbers. */
import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter a number");
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        int max = arr[0];
        int indexMin = 0;
        int indexMax = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                indexMin = i;
            }

        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                indexMax = i;
            }
        }
        System.out.println("The smallest number index is: " + indexMin);
        System.out.println("The largest number index is: " + indexMax);
        sc.close();
    }
}