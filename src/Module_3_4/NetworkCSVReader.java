package Module_3_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NetworkCSVReader {
    public static void main(String[] args) {

        URL url = null;
        double sum = 0.0;
        int count = 0;
        List<String> lines = new ArrayList<>();

        try {
            url = new URL("https://users.metropolia.fi/~olliv/olio/korvike.csv");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        try (InputStream inputStream = url.openStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("1.1.2023")) {
                    lines.add(line);
                }
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            for (String s : lines) {
                String[] parts = s.split(",");
                if (parts.length >= 4) {
                    double temperature = Double.parseDouble(parts[3].trim());
                    sum += temperature;
                    count++;
                }
            }

            double average = sum / count;
            System.out.printf("Average temperature on 1.1.2023 was %.2f°C", average);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
    }
}
