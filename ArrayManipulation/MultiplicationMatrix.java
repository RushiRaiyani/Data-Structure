// Read two matrices, first 3x2 and second 2x3, perform multiplication operation 
// and store result in third matrix and print it.
package Lab_5;

import java.util.Scanner;

public class MultiplicationMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter number of rows and column of matrix A:");
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println("enter number of rows and column of matrix B:");
        int e = sc.nextInt();
        int f = sc.nextInt();
        int a[][] = new int[c][d];
        int b[][] = new int[e][f];
        int x[][] = new int[c][f];
        int pro = 0, k;
        if (d == e) {
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < d; j++) {
                    System.out.println("Enter element in matrix 1 at index " + i + " " + j);
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < e; i++) {
                for (int j = 0; j < f; j++) {
                    System.out.println("Enter element in matrix 2 at index " + i + " " + j);
                    b[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < f; j++) {
                    k = 0;
                    pro = 0;
                    while (k < e) {
                        pro = pro + (a[i][k] * b[k][j]);
                        k++;
                    }
                    x[i][j] = pro;
                }
            }
            System.out.println("multiplied matrix is:");
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < f; j++) {
                    System.out.print(x[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("matrix multiplication not possible");
        }
        sc.close();
    }
}
