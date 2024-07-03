// Suppose you are senior developer for an Relational Database Management System 
// named "Array Database" where everything is implemented using only array, today 
// your task is to implement aggregate function like sum, min, max, avg. For simplicity, 
// assume that your database can only store integers.

import java.util.Scanner;

public class DatabaseFunction {
    public static int sum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int min(int arr[]) {
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (temp > arr[i]) {
                temp = arr[i];
            }
        }
        return temp;
    }

    public static int max(int arr[]) {
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
            }
        }
        return temp;
    }

    public static double avg(int arr[], int a) {
        double ans = (double) a / arr.length;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1));
            arr[i] = sc.nextInt();
        }
        int a = sum(arr);
        System.out.println("sum of elements is:" + sum(arr));
        System.out.println("min of elements is:" + min(arr));
        System.out.println("max of elements is:" + max(arr));
        System.out.println("avg of elements is:" + avg(arr, a));
        sc.close();
    }
}
