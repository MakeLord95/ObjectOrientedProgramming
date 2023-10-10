package Module_8_2;

import java.util.Arrays;

public class MeanCalculator {
    public static void main(String[] args) {
        double[] numbers = {42, 17, 88, 3, 56, 29, 64, 9, 71, 12, 37, 50, 6, 95, 23, 68, 5, 82, 14, 77};

        double mean = Arrays.stream(numbers).sum() / numbers.length;
        System.out.println(mean);
    }
}
