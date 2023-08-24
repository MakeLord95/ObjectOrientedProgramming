package Module_1_4;

import java.util.Scanner;

public class SubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many integers do you want to enter: ");
        final int size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            array[i] = scanner.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;

        for (int start = 0; start < array.length; start++) {
            int currentSum = 0;

            for (int end = start; end < array.length; end++) {
                currentSum += array[end];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndex = start;
                    endIndex = end;
                }
            }
        }

        System.out.printf("\nMaximum sum: %d\n", maxSum);
        System.out.printf("Subarray indices: %d - %d", (startIndex + 1), (endIndex + 1));

    }
}
