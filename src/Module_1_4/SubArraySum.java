package Module_1_4;

import java.util.Scanner;

// TODO: Rewrite with own code


public class SubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        int end = 0;
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        int tempStart = 0;
        int currentSum = 0;
        */

        System.out.print("How many integers do you want to enter: ");
        final int numbers = scanner.nextInt();

        int[] list = new int[numbers];

        for (int i = 0; i < numbers; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            list[i] = scanner.nextInt();
        }

        /*
        for (int i = 0; i < numbers; i++) {
            currentSum += list[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        */

        System.out.printf("Maximum sum: %d", maxSum);
        System.out.printf("Integers: %d - %d", start + 1, end + 1);

    }
}
