// WAP to replace lowercase characters by uppercase & vice-versa in a user specified 
// string.

import java.util.Scanner;

public class ConvertStringCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String:");
        String s = sc.nextLine();
        String st = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                temp = s.charAt(i) + "";
                st = st + temp.toUpperCase();
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                temp = s.charAt(i) + "";
                st = st + temp.toLowerCase();
            } else {
                st = st + s.charAt(i);
            }
        }
        System.out.println(st);
        sc.close();
    }
}
