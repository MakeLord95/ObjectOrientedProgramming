package Module_1_3;

import java.util.Scanner;

public class PrimeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Starting number: ");
        int startingNumber = scanner.nextInt();

        System.out.print("Ending number: ");
        int endingNumber = scanner.nextInt();

        System.out.printf("The program will now find prime numbers between %d and %d\n", startingNumber, endingNumber);

        for (int nbr = startingNumber; nbr <= endingNumber; nbr++) {
            boolean isPrime = true;

            if (nbr <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(nbr); i++) {
                    if (nbr % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.printf("%d is a prime number!\n", nbr);
            }
        }
    }
}
