package Module_1_4;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int j = 0;
        boolean firstRun = true;

        System.out.print("How many integers do you want in the array: ");
        int arraySize = scanner.nextInt();

        if (arraySize > 0) {

            int[] array = new int[arraySize];
            int[] arrayNoDupes = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                System.out.printf("Enter integer %d: ", i + 1);
                array[i] = scanner.nextInt();
            }

            Arrays.sort(array);

            int currentNBR = array[0];

            for (int k : array) {
                if (firstRun) {
                    arrayNoDupes[j] = currentNBR;
                    firstRun = false;
                    j++;
                } else if (k != currentNBR) {
                    currentNBR = k;
                    arrayNoDupes[j] = currentNBR;
                    j++;
                }
            }

            System.out.println("The array without duplicates:");

            for (int listNoDupe : arrayNoDupes) {
                if (listNoDupe != 0) {
                    System.out.printf("%d ", listNoDupe);
                }
            }
        }
    }
}
