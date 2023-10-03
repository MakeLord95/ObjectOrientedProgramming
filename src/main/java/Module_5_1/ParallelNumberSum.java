package Module_5_1;

import java.util.Arrays;

public class ParallelNumberSum extends Thread {
    private int sum;
    private final int[] numbers;

    public ParallelNumberSum(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        for (int number : numbers) {
            sum += number;
        }
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = new int[100];

        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }

        int numberOfThreads = 10;
        int batchSize = numbers.length / numberOfThreads;

        ParallelNumberSum[] parallelNumberCalculator = new ParallelNumberSum[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;

            int[] batchNumbers = Arrays.copyOfRange(numbers, startIndex, endIndex);

            parallelNumberCalculator[i] = new ParallelNumberSum(batchNumbers);
            parallelNumberCalculator[i].start();
        }

        int totalSum = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                parallelNumberCalculator[i].join();
                totalSum += parallelNumberCalculator[i].getSum();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.printf("The total sum of all numbers is %d\n", totalSum);
    }
}
