
// Write a program to find whether the array contains a duplicate number or not.
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of terms:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter a number at index " + i);
            arr[i] = scanner.nextInt();
        }
        boolean isPresent = false;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] == arr[j]) {
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                break;
            }
        }
        if (isPresent) {
            System.out.println("Duplicate found");
        } else {
            System.out.println("Duplicate not found");
        }
        scanner.close();
    }
}