
// Write a program to calculate sum of numbers from m to n.
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers:");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum = sum + i;
        }
        System.out.println("Sum of the numbers is:" + sum);
        sc.close();
    }
}