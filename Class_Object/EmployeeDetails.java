// Create class Employee_Detail with attributes Employee_ID, Name, Designation, 
// and Salary. Write a program to read the detail from user and print it. 
package Class_Object;

import java.util.Scanner;

class Employee_Detail {
    int Employee_ID;
    String Name;
    String Designation;
    double Salary;

    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID:");
        Employee_ID = sc.nextInt();
        System.out.println("Enter Name:");
        Name = sc.next();
        System.out.println("Enter Designation:");
        Designation = sc.next();
        System.out.println("Enter Salary:");
        Salary = sc.nextDouble();
        sc.close();
    }

    public void printDetails() {
        System.out.println("Employee ID: " + Employee_ID);
        System.out.println("Name: " + Name);
        System.out.println("Designation: " + Designation);
        System.out.println("Salary: " + Salary);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Employee_Detail ed = new Employee_Detail();
        ed.getDetails();
        ed.printDetails();
    }
}
