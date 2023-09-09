package Module_3_4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FibonacciSequence {
    public static void main(String[] args) {
        int n = 100;
        String csvFileName = "fibonacci.csv";

        long[] fibonacciNumbers = new long[n];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        try (FileWriter fileWriter = new FileWriter(csvFileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (long number : fibonacciNumbers) {
                printWriter.println(number);
            }

            System.out.printf("Wrote Fibonacci Sequence to %s -file", csvFileName);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
