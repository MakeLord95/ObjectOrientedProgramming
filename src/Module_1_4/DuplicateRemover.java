package Module_1_4;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int j = 0;
        boolean firstRun = true;

        System.out.print("How many integers do you want in the list: ");
        int listSize = scanner.nextInt();

        if (listSize > 0) {

            int[] list = new int[listSize];
            int[] listNoDupes = new int[listSize];

            for (int i = 0; i < listSize; i++) {
                System.out.printf("Enter integer %d: ", i + 1);
                list[i] = scanner.nextInt();
            }

            Arrays.sort(list);

            int currentNBR = list[0];

            for (int k : list) {
                if (firstRun) {
                    listNoDupes[j] = currentNBR;
                    firstRun = false;
                    j++;
                } else if (k != currentNBR) {
                    currentNBR = k;
                    listNoDupes[j] = currentNBR;
                    j++;
                }
            }

            System.out.println("The list without duplicates:");

            for (int listNoDupe : listNoDupes) {
                if (listNoDupe != 0) {
                    System.out.printf("%d ", listNoDupe);
                }
            }
        }
    }
}
