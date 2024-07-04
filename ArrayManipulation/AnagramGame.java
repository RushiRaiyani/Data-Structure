// Design anagram game using array. 
//  Allow a user to enter N words and store it in an array. 
//  Generate a random number between 0 to N-1. 
//  Based on the random number generated display the word stored at that 
// index of an array and allow user to enter its anagram. 
//  Check whether the word entered by the user is an anagram of displayed 
// number or not and display an appropriate message. 
//  Given a word A and word B. B is said to be an anagram of A if and only if 
// the characters present in B is same as characters present in A, 
// irrespective of their sequence. For ex: “LISTEN” == “SILENT”
package Lab_5;

import java.util.Scanner;

public class AnagramGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of names you want to enter:");
        int n = sc.nextInt();
        String name[] = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name at index " + i);
            name[i] = sc.next();
        }
        int index = (int) (Math.random() * n);
        System.out.println(index);
        System.out.println(name[index]);
        System.out.println("Enter anagram:");
        String anagram = sc.next();
        int temp = 0;
        if (name[index].length() != anagram.length()) {
            System.out.println("Not an anagram");
            temp = -1;
        }
        for (int i = 0; i < name[index].length() && temp != -1; i++) {
            for (int j = 0; j < anagram.length(); j++) {
                if (name[index].charAt(i) == anagram.charAt(j)) {
                    temp++;
                    break;
                }
            }
        }
        if (temp == anagram.length()) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not an anagram");
        }
        sc.close();
    }
}
