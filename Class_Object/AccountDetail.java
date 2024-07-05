// Create a class BankAccount with attributes like account number, balance, 
// account holder and name. Create an array of BankAccount objects to store 
// bank accounts. Implement methods to deposit money, withdraw money and 
// check balance.
package Class_Object;

import java.util.Scanner;

class BankAccount {
    int accountNumber;
    double balance;
    String name;

    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        accountNumber = sc.nextInt();
        System.out.println("Enter Name:");
        name = sc.next();
        System.out.println("Enter Balance:");
        balance = sc.nextDouble();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class AccountDetail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        BankAccount bankAccount[] = new BankAccount[n];
        for (int i = 0; i < n; i++) {
            bankAccount[i] = new BankAccount();
            bankAccount[i].getDetails();
            System.out.println("Enter amount to deposit:");
            bankAccount[i].deposit(sc.nextInt());
            System.out.println("Enter amount to withdraw:");
            bankAccount[i].withdraw(sc.nextInt());
            bankAccount[i].checkBalance();
        }
        sc.close();
    }
}
