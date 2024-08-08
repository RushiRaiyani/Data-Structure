// Write a program to convert infix notation to prefix notation using stack.
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

    public char peep() {
        if (top == -1) {
            return '0';
        } else {
            return arr[top];
        }
    }

    public int precendence(int sign) {
        if (sign == '+' || sign == '-') {
            return 1;
        } else if (sign == '*' || sign == '/') {
            return 2;
        } else if (sign == '^') {
            return 3;
        } else if (sign >= 'a' && sign <= 'z') {
            return 0;
        } else {
            return -1;
        }
    }

    public String postfix() {
        String polish = "";
        int i = 0;
        char next = s.charAt(i);
        push('(');
        while (i < s.length()) {
            next = s.charAt(i);
            if (top < 0) {
                System.out.println("Invalid");
                return "";
            }
            if (next == '(') {
                push(next);
            } else if (next == ')') {
                while (arr[top] != '(') {
                    polish = polish + pop();
                }
                pop();
            } else {
                if (next >= 'a' && next <= 'z') {
                    polish = polish + next;
                } else if (precendence(peep()) < precendence(next)) {
                    push(next);
                } else if (precendence(peep()) == precendence(next)) {
                    if (next == '^') {
                        polish = polish + pop();
                        push('^');
                    } else {
                        while (precendence(peep()) > precendence(next)) {
                            polish = polish + pop();
                        }
                        push(next);
                    }
                } else {
                    while (precendence(peep()) > precendence(next)) {
                        polish = polish + pop();
                    }
                    push(next);
                }
            }
            i++;
        }
        StringBuffer sb = new StringBuffer(polish);
        return sb.reverse().toString();
    }

}

public class InfixToPrefixExpression {
    public static String reverseInfix(String s) {
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                ans = ans + ')';
            } else if (s.charAt(i) == ')') {
                ans = ans + '(';
            } else {
                ans = ans + s.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter infix notation:");
        String s = sc.next();
        String ans = reverseInfix(s);
        ans = ans + ')';
        System.out.println(ans);
        MyStack st = new MyStack((s.length() + 1), ans);
        String polish = st.postfix();
        System.out.println("Prefix notation is: " + polish);
        sc.close();
    }
}
