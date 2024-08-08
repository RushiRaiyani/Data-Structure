// Write a program to convert infix notation to postfix notation using stack.

import java.util.Scanner;

class MyStack {
    char arr[];
    String s;

    public MyStack(int n, String s) {
        this.s = s;
        this.arr = new char[n];
    }

    int top = -1;

    // push
    public void push(char number) {

        if (top >= arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        } else {
            top++;
            arr[top] = number;
            System.out.println("Element is pushed successfully");
            return;
        }
    }

    // pop
    public char pop() {
        if (top == -1) {
            return '0';
        } else {
            top--;
            return arr[top + 1];
        }
    }

    int stackPrecendence(char sign) {
        if (sign == '+' || sign == '-') {
            return 2;
        } else if (sign == '*' || sign == '/') {
            return 4;
        } else if (sign == '^') {
            return 5;
        } else if ((sign >= 'A' && sign <= 'Z') || (sign >= 'a' && sign <= 'z')) {
            return 8;
        } else if (sign == '(') {
            return 0;
        } else {
            return -1;
        }
    }

    int inputPrecendence(char sign) {
        if (sign == '+' || sign == '-') {
            return 1;
        } else if (sign == '*' || sign == '/') {
            return 3;
        } else if (sign == '^') {
            return 6;
        } else if ((sign >= 'A' && sign <= 'Z') || (sign >= 'a' && sign <= 'z')) {
            return 7;
        } else if (sign == '(') {
            return 9;
        } else {
            return 0;
        }
    }

    int rank(char sign) {
        if (sign == '+' || sign == '-' || sign == '*' || sign == '/' || sign == '^') {
            return -1;
        } else if ((sign >= 'A' && sign <= 'Z') || (sign >= 'a' && sign <= 'z')) {
            return 1;
        } else {
            return 0;
        }
    }

    public String postfix() {
        String polish = "";
        int rank = 0;
        int i = 0;
        char next = s.charAt(i);
        push('(');
        while (i < s.length()) {
            next = s.charAt(i);
            if (top < 0) {
                System.out.println("Invalid");
                return "";
            }
            int check1 = stackPrecendence(arr[top]);
            int check2 = inputPrecendence(next);

            while (stackPrecendence(arr[top]) > inputPrecendence(next)) {
                char temp = pop();
                polish = polish + temp;
                rank += rank(temp);
                if (rank < 1) {
                    System.out.println("Invalid");
                    return "";
                }
            }
            if (check1 != check2) {
                push(next);
            } else {
                pop();
            }
            i++;
        }
        if (top != 0 || rank != 1) {
            System.out.println("invalid");
        } else {
            System.out.println("Valid");
        }
        return polish;
    }

}

public class InfixToPostfixExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix notation and add extra ')' at last: ");
        String s = sc.next();
        MyStack st = new MyStack((s.length() + 1), s);
        String polish = st.postfix();
        System.out.println("Postfix notation is: " + polish);
        sc.close();
    }
}
