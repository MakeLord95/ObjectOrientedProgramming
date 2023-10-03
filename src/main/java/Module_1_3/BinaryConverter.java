package Module_1_3;

import java.util.Scanner;

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        int decimal = 0;
        int length = binary.length();

        for (int i = length - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            if (bit == '1') {
                decimal += (int) Math.pow(2, length - 1 - i);
            }
        }

        System.out.println("Decimal equivalent: " + decimal);
    }
}
