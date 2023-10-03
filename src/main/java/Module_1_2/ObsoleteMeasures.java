package Module_1_2;

import java.util.Scanner;

public class ObsoleteMeasures {
    public static void main(String[] args) {
        int naula, leiviska, final_naula;
        double luoti, final_luoti;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter weight in grams (g): ");
        double grams = scanner.nextDouble();


        luoti = grams / 13.28;
        naula = (int) luoti / 32;
        leiviska = naula / 20;

        final_naula = naula % 20;

        final_luoti = luoti % 32;


        System.out.println("Weight (g): " + grams);
        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.", grams, leiviska, final_naula, final_luoti);

    }
}
