package Module_1_4;

import java.util.Arrays;
import java.util.Scanner;

// TODO: WIP

public class DuplicateRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many integers do you want in the list: ");
        int listSize = scanner.nextInt();

        int[] list = new int[listSize];
        int[] listNoDupes = new int[listSize];

        for (int i = 0; i < listSize; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);

        /*
        for (int i = 0; i < list.length; i++) {

        }
        */

        for (int listNoDupe : listNoDupes) {
            System.out.printf("%d ", listNoDupe);
        }

    }
}
