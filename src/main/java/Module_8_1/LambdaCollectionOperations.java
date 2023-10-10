package Module_8_1;

import java.util.Arrays;

public class LambdaCollectionOperations {
    public static void main(String[] args) {
        int[] numbers = {10, 16, 7, 20, 19, 30, 69, 29, 17, 7, 6, 12, 66};

        System.out.println("Before sorting:");
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }

        int[] evenNumbers = Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .toArray();

        System.out.println("\nAfter filtering out odd numbers:");
        for (int number : evenNumbers) {
            System.out.printf("%d ", number);
        }

        int[] doubledNumbers = Arrays.stream(evenNumbers)
                .map(number -> number * 2)
                .toArray();

        System.out.println("\nAfter doubling the even numbers:");
        for (int number : doubledNumbers) {
            System.out.printf("%d ", number);
        }

        int sum = Arrays.stream(numbers)
                .sum();

        System.out.printf("\nSum of the numbers: %d\n", sum);
    }
}
