
// Write a program to determine if an input character string is of the form a^ib^i
// where i >= 1 i.e., Number of ‘a’ should be equal to number of ‘b’.
import java.util.Scanner;

public class StringEqualityAB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string in form of A^iB^i:");
        String input = sc.next();
        int countA = 0, countB = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                countA++;
            } else if (input.charAt(i) == 'b') {
                countB++;
            } else {
                System.out.println("Invalid input. String should contain only characters 'a' and 'b'");
            }
        }
        if (countA == countB) {
            System.out.println("Valid String");
        } else {
            System.out.println("Invalid String");
        }
        sc.close();
    }
}