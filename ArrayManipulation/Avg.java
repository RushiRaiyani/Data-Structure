
//Write a program to calculate average of first n numbers.
import java.util.Scanner;

public class Avg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of terms:");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        System.out.println("Average of terms are:" + (sum / n));
        scanner.close();
    }
}
