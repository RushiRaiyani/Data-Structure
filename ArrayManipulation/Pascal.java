
// WAP to print Pascal triangle.
import java.util.Scanner;

public class Pascal {
    public static int fact(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        return ans;
    }

    public static int combi(int n, int r, int c) {
        int give = 0;
        give = n / (r * c);
        return give;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int row = sc.nextInt();
        int k = 1;
        for (int i = 1; i <= row; i++) {
            k = 1;
            int n = 0;
            int r = 0;
            int c = 0;
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j % 2 == 1) {
                    n = Pascal.fact(i - 1);
                    r = Pascal.fact(k - 1);
                    c = Pascal.fact(i - k);

                    System.out.print(Pascal.combi(n, r, c));
                    k++;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        sc.close();
    }
}
