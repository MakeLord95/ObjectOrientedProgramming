package Module_8_2;

import java.util.Arrays;

public class ListFilterTransform {
    public static void main(String[] args) {
        int[] numbers = {42, 17, 88, 3, 56, 29, 64, 9, 71, 12, 37, 50, 6, 95, 23, 68, 5, 82, 14, 77};

        System.out.println(Arrays.toString(numbers));

        int[] oddNumbers = Arrays.stream(numbers)
                .filter(number -> number % 2 != 0)
                .toArray();

        System.out.println(Arrays.toString(oddNumbers));

        int[] doubledNumbers = Arrays.stream(oddNumbers)
                .map(number -> number * 2)
                .toArray();

        System.out.println(Arrays.toString(doubledNumbers));

        int sum = Arrays.stream(doubledNumbers).sum();

        System.out.println(sum);
    }
}
