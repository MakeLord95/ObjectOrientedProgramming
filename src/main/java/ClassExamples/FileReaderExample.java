package ClassExamples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileReaderExample {
    public static void main(String[] args) {

        List<String> rows = new ArrayList<>();

        FileReader fr = null;

        try {
            fr = new FileReader("/home/make/hehe.txt");
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found. Check file path");
            System.exit(1);
        }
        BufferedReader br = new BufferedReader(fr);

        String row = null;

        do {
            try {
                row = br.readLine();
            } catch (IOException e) {
                System.out.println("File read failed.");
                System.exit(2);
            }
            if (row != null) {
                //System.out.printf("%s\n", row);
                rows.add(row);
            }
        } while (row != null);

        Random r = new Random();
        int randomIndex = r.nextInt(0, rows.size() - 1);

        System.out.printf("Laughter of the day: %s", rows.get(randomIndex));

        try {
            br.close();
        } catch (IOException e) {
            System.out.println("Error closing the BufferedReader!");
            System.exit(3);
        }
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("Error closing the FileReader");
            System.exit(4);
        }
    }
}
