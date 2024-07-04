// Read two 2x2 matrices and perform addition of matrices into third matrix and 
// print it
package Lab_5;

import java.util.Scanner;

public class AdditionMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and cols:");

        int arr1[][] = new int[sc.nextInt()][sc.nextInt()];
        int arr2[][] = new int[arr1.length][arr1[0].length];
        int arr3[][] = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.println("Enter element in matrix 1 at index " + i + " " + j);
                arr1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.println("Enter element in matrix 2 at index " + i + " " + j);
                arr2[i][j] = sc.nextInt();
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("Matrix after addition is:");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
