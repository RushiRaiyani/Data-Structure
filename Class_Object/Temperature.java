// Create methods to convert temperature from Celsius to Fahrenhit and vice 
// versa. Take temperature input from user and call the appropriate conversion 
// method.
package Class_Object;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for celsius to fahrenheit conversion and 2 for fahrenheit to celsius conversion");
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println("Enter temperature in Celsius:");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println("Temperature in Fahrenheit: " + fahrenheit);
        } else if (n == 2) {
            System.out.println("Enter temperature in Fahrenheit:");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + celsius);
        } else {
            System.out.println("Invalid input");
        }
        scanner.close();
    }
}
