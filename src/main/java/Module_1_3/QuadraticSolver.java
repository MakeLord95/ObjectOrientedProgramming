package Module_1_3;

import java.util.Scanner;

public class QuadraticSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coefficients of the quadratic equation!");

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d > 0) {
            double root_1 = (-b + Math.sqrt(d)) / (2 * a);
            double root_2 = (-b - Math.sqrt(d)) / (2 * a);

            System.out.println("Found 2 roots!");
            System.out.printf("Root 1: %f\n", root_1);
            System.out.printf("Root 2: %f\n", root_2);
        } else if (d == 0) {
            double root = -b / (2 * a);

            System.out.println("Found 1 root!");
            System.out.printf("Root: %f\n", root);
        } else {
            System.out.println("No real roots found!");
        }
    }
}
