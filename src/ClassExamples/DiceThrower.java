package ClassExamples;

import java.util.Random;
import java.util.Scanner;

public class DiceThrower extends Thread {
    private final long throwCount;
    private final Random random = new Random();
    private long totalDieThrowSum;

    public DiceThrower(long throwCount) {
        this.throwCount = throwCount;
    }

    public void run() {
        for (long i = 0; i < throwCount; i++) {
            totalDieThrowSum += random.nextInt(6) + 1;
        }
    }

    public long getTotalDieThrowSum() {
        return totalDieThrowSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of times you want to throw the dice: ");
        long throwCount = scanner.nextInt();

        System.out.print("Enter the number of threads you want to use: ");
        int threadCount = scanner.nextInt();

        DiceThrower[] diceArray = new DiceThrower[threadCount];

        for (int i = 0; i < diceArray.length; i++) {
            diceArray[i] = new DiceThrower(throwCount / threadCount);
            diceArray[i].start();
        }

        long totalSum = 0;

        for (DiceThrower diceThrower : diceArray) {
            try {
                diceThrower.join();
                totalSum += diceThrower.getTotalDieThrowSum();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("The total sum of all dice throws is %d\n", totalSum);
    }
}
