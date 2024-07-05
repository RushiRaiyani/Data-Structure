// Create array of object of class Student_Detail with attributes Enrollment_No, 
// Name, Semester, CPI for 5 students, scan their information and print it.
package Class_Object;

import java.util.Scanner;

class Student_Detail {
    int enrollment_No;
    String name;
    int semester;
    double cpi;

    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Enrollment no:");
        this.enrollment_No = sc.nextInt();
        System.out.println("Enter Name:");
        this.name = sc.next();
        System.out.println("Enter semester:");
        this.semester = sc.nextInt();
        System.out.println("Enter CPI:");
        this.cpi = sc.nextDouble();
    }

    public void printDetails() {
        System.out.println("Enrollment No: " + enrollment_No);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
        System.out.println("CPI: " + cpi);
    }
}

public class ObjectArray {
    public static void main(String[] args) {
        Student_Detail s[] = new Student_Detail[5];
        for (int i = 0; i < 5; i++) {
            s[i] = new Student_Detail();
            s[i].getDetails();
            s[i].printDetails();
        }
    }
}
