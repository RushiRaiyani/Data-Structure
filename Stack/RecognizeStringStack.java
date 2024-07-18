
// How stack can be used to recognize strings aca, bcb, abcba, abbcbba? Write a 
// program to solve the above problem.
import java.util.Scanner;

class MyStack {
    char arr[];
    int top = -1;

    public MyStack(int n) {
        this.arr = new char[n];
    }

    public void push(char number) {
        if (top >= arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        } else {
            top++;
            arr[top] = number;
            return;
        }
    }

    // pop
    public char pop() {
        if (top == -1) {
            return '\0';
        } else {
            char poppedElement = arr[top];
            top--;
            return poppedElement;
        }
    }
}

public class RecognizeStringStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String which ends with space:");
        String s = sc.nextLine();
        int n = s.indexOf("c");
        if (n == -1 || n == s.length() - 1 - (n - 1) || s.charAt(s.length() - 1) != ' ') {
            System.out.println("Invalid String");
            return;
        }

        MyStack select = new MyStack(n);
        for (int i = 0; i < n; i++) {
            select.push(s.charAt(i));
        }

        boolean isValid = true;
        for (int i = n + 1; s.charAt(i) != ' '; i++) {
            if (select.pop() != s.charAt(i)) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Invalid String");
        } else {
            System.out.println("Valid String");
        }
        sc.close();
    }
}
