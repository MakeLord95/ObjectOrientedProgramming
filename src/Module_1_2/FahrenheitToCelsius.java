package Module_1_2;

import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature in fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) * ((double) 5 / 9);
        System.out.printf("Temperature in Celsius: %.1f\n",  celsius);
    }
}
