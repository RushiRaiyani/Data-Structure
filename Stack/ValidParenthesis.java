
// Chef has a string which contains only the characters '{', '}', '[', ']', '(' and ')'. Now 
// Chef wants to know if the given string is balanced or not. If is balanced then 
// print 1, otherwise print 0.
import java.util.Scanner;

class MyStack {
    char arr[];

    public MyStack(int n) {
        this.arr = new char[n];
    }

    int top = -1;

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
            return '1';
        } else {
            top--;
            return arr[top + 1];
        }
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a valid parenthesis");
        String s = sc.next();
        boolean isCorrect = false;
        MyStack stack = new MyStack(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    isCorrect = false;
                    break;
                } else {
                    char temp = stack.pop();
                    if ((temp == '(' && s.charAt(i) == ')') || (temp == '{' && s.charAt(i) == '}')
                            || (temp == '[' && s.charAt(i) == ']')) {
                        temp = 0;
                        isCorrect = true;
                    } else {
                        isCorrect = false;
                        break;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            isCorrect = false;
        }
        if (isCorrect) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        sc.close();
    }
}