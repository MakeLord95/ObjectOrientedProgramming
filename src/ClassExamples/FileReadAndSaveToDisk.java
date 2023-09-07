package ClassExamples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileReadAndSaveToDisk {
    public static void saveToDisk(List rows) {
        try (FileOutputStream fo = new FileOutputStream("/home/make/hehe.lol"); ObjectOutputStream oo = new ObjectOutputStream(fo)) {

            oo.writeObject(rows);

            oo.close();
            fo.close();
            System.out.println("Wrote laughter's to disk.");

        } catch (IOException e) {
            System.out.println("Error writing to file");
            System.exit(2);
        }
    }

    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();

        try (FileReader fr = new FileReader("/home/make/hehe.txt"); BufferedReader br = new BufferedReader(fr)) {
            String row;

            do {
                row = br.readLine();

                if (row != null) {
                    System.out.printf("%s\n", row);
                    rows.add(row);
                }
            } while (row != null);

        } catch (IOException e) {
            System.out.println("Error handling the file");
            System.exit(1);
        }

        Random r = new Random();
        int randomIndex = r.nextInt(0, rows.size() - 1);

        System.out.printf("Laughter of the day: %s", rows.get(randomIndex));

        saveToDisk(rows);
    }
}
