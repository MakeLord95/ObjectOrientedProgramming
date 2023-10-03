package Module_1_3;

import java.util.Scanner;

public class MultiplicationExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MIN = 1;
        final int MAX = 10;
        int correct_results;

        System.out.println("Welcome to Multiplication table exam.");
        do {
            correct_results = 0;

            for (int i = MIN; i <= MAX; i++) {
                int factor_1 = (int) (Math.random() * (MAX - MIN)) + MIN;
                int factor_2 = (int) (Math.random() * (MAX - MIN)) + MIN;

                int result = factor_1 * factor_2;

                System.out.printf("\nQuestion %d: What is the result of %d * %d: ", i, factor_1, factor_2);
                //System.out.println(result);

                int userGuess = scanner.nextInt();

                if (userGuess == result) {
                    correct_results += 1;
                    System.out.println("Correct");
                } else {
                    System.out.printf("Incorrect. Correct result is %d\n", result);
                }
            }
            if (correct_results == 10) {
                System.out.println("\nCongratulations. You got 10 / 10!");
            } else {
                System.out.printf("Failure. You got %d / 10 correct! Try again!\n", correct_results);
            }
        } while (correct_results < 10);
    }
}
