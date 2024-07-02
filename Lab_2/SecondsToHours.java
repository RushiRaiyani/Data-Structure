// WAP to convert seconds into hours, minutes & seconds and print in HH:MM:SS 
// [e.g. 10000 seconds mean 2:46:40 (2 Hours, 46 Minutes, 40 Seconds)].
package Lab_2;

import java.util.Scanner;

public class SecondsToHours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sec:");
        int s = sc.nextInt();
        int h = 0;
        int m = 0;
        if (s >= 3600) {
            h = s / 3600;
            s = s - (h * 3600);
            if (s >= 60) {
                m = s / 60;
                s = s - (m * 60);
            }
        } else {
            m = s / 60;
            s = s - 60;
        }
        System.out.println(h + ":" + m + ":" + s);
        sc.close();
    }
}
