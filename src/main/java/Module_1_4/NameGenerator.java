package Module_1_4;

import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MIN = 0;
        final int MAX = 6;

        final String[] firstNames = {"Matti", "Kimmo", "Sami", "Tiina", "Saara", "Veli-Matti", "Timo"};
        final String[] lastNames = {"Mäkinen", "Virtanen", "Nieminen", "Laine", "Järvinen", "Koskinen", "Saari"};

        System.out.print("How many random names do you want to generate: ");
        int generationAmount = scanner.nextInt();

        if (generationAmount > 0) {
            String[] fullNames = new String[generationAmount];

            for (int i = 0; i <= generationAmount - 1; i++) {
                int firstNameIndex = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
                int lastNameIndex = (int) (Math.random() * (MAX - MIN + 1)) + MIN;

                fullNames[i] = firstNames[firstNameIndex] + " " + lastNames[lastNameIndex];

                System.out.printf("Name %d: %s\n", i + 1, fullNames[i]);
            }
        }
    }
}
