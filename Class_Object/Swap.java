// Write a program to swap two numbers using user-defines method.
package Class_Object;

import java.util.Scanner;

class Swaped {
    public void swapedNo(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping a=" + a + " b=" + b);
    }
}

public class Swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        Swaped s = new Swaped();
        s.swapedNo(a, b);
        sc.close();
    }
}
