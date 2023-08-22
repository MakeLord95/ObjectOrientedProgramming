package Module_1_2;

import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first leg: ");
        double leg_1 = scanner.nextDouble();

        System.out.println("Enter the second leg: ");
        double leg_2 = scanner.nextDouble();

        double hypotenuse = Math.sqrt(Math.pow(leg_1, 2) + Math.pow(leg_2, 2));

        System.out.printf("The hypotenuse of the triangle is: %6.2f", hypotenuse);

    }
}
