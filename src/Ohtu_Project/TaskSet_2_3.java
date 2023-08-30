package Ohtu_Project;


import java.util.Random;


public class TaskSet_2_3 {
    public static void main(String[] args) {
        double[] ageDistribution = {0.1, 0.2, 0.3, 0.2, 0.1, 0.05, 0.05};
        double[] cumulativeDistribution = new double[ageDistribution.length];

        cumulativeDistribution[0] = ageDistribution[0];

        for (int i = 1; i < ageDistribution.length; i++) {
            cumulativeDistribution[i] = cumulativeDistribution[i - 1] + ageDistribution[i];
        }

        int numberOfSamples = 1000;
        int[] generatedAges = new int[numberOfSamples];

        Random random = new Random();

        for (int i = 0; i < numberOfSamples; i++) {
            double randomValue = random.nextDouble();
            int age = findAgeFromDistribution(randomValue, cumulativeDistribution);
            generatedAges[i] = age;
        }

        for (int age : generatedAges) {
            System.out.printf("%d\n", age);
        }
        System.out.println();
    }

    private static int findAgeFromDistribution(double value, double[] cumulativeDistribution) {
        for (int i = 0; i < cumulativeDistribution.length; i++) {
            if (value < cumulativeDistribution[i]) {
                return 18 + i;
            }
        }
        return 18 + cumulativeDistribution.length - 1;
    }
}
