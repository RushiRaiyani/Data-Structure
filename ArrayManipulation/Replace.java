
// Read n numbers in an array then read two different numbers, replace 1st
// number with 2nd number in an array and print its index and final array.
import java.util.Scanner;

public class Replace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter a number at index " + i);
            arr[i] = sc.nextInt();
        }
        int indexA = -1;
        int indexB = -1;
        System.out.println("enter 2 numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (arr[i] == a) {
                indexA = i;
            }
            if (arr[i] == b) {
                indexB = i;
            }
        }
        if (indexA < 0 || indexB < 0) {
            System.out.println("Number is not present");
        }
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}