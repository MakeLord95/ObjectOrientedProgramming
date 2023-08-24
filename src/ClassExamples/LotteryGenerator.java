package ClassExamples;

public class LotteryGenerator {
    public static void main(String[] args) {
        final int NUMBERS = 7, MAX_NUMBER = 39;
        int nbr;

        int[] row = new int[NUMBERS];
        boolean exists;

        for (int i = 0; i < NUMBERS; i++) {
            do {
                nbr = (int) (Math.random() * MAX_NUMBER) + 1;

                exists = false;


                for (int j = 0; j <= i - 1; j++) {
                    if (row[j] == nbr) {
                        exists = true;
                        break;
                    }
                }
            } while (exists);
            row[i] = nbr;

            // System.out.println(nbr);
        }

        java.util.Arrays.sort(row);
        for (int j : row) {
            System.out.println(j);
        }
    }
}
