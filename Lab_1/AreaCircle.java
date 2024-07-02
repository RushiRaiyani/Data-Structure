// Write a program to calculate area of a Circle (A = πr2).
package Lab_1;

import java.util.Scanner;

public class AreaCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius of circle:");
        float a = sc.nextFloat();
        System.out.println("Area of circle is:" + (3.14 * a * a));
        sc.close();
    }
}