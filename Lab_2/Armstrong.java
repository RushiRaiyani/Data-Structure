// WAP to print Armstrong number from 1 to 1000.
package Lab_2;

import java.lang.Math;

public class Armstrong {
    public static void main(String[] args) {
        String a = "";
        for (int i = 1; i <= 100; i++) {
            a = i + a;
            a = a + "";
            int n = 10;
            int sum = 0;
            for (int j = 0; j < a.length(); j++) {
                sum = (int) (sum + Math.pow(i % n, a.length()));
                n = n * 10;
            }
            if (sum == i) {
                System.out.print(i + ",");
            }
            a = "";
        }
    }
}