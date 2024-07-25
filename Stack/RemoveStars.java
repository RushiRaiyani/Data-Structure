import java.util.Scanner;

class MyStack {
    char arr[];

    public MyStack(int n) {
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
            return 'X';
        } else {
            top--;
            return arr[top + 1];
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}

public class RemoveStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with stars");
        String s = sc.next();
        int n = s.length();
        MyStack stars = new MyStack(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stars.pop();
            } else {
                stars.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stars.isEmpty()) {
            sb.append(stars.pop());
        }
        System.out.println("String after removing stars is:" + sb.reverse().toString());
        sc.close();
    }
}
