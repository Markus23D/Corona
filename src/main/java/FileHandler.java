import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File LoadFromCSV;

    public boolean validateLine(String[] line) {
        if (!line[0].equals("Hovedstaden") && (!line[0].equals("Midtjylland")) && (!line[0].equals("Nordjylland"))&& (!line[0].equals("Sjælland")) && (!line[0].equals("Syddanmark"))) {
            return false;
        }
        return true;
    }

    public FileHandler() {
        LoadFromCSV = new File("11_noegletal_pr_region_pr_aldersgruppe.csv");
    }

    public void parseData() {
        ArrayList<Covid19Data> covid19List = new ArrayList<>();
        try (Scanner scanner = new Scanner(LoadFromCSV, StandardCharsets.ISO_8859_1)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                if (values.length == 7) {
                    String region = values[0];
                    String aldersgruppe = values[1];
                    int beKræftedeTilfælde = Integer.parseInt(values[2].trim());
                    int døde = Integer.parseInt(values[3].trim());
                    int indlagtePåIntensiv = Integer.parseInt(values[4].trim());
                    int indlagte = Integer.parseInt(values[5].trim());

                    if (validateLine(values)) {
                        Covid19Data covid19Data = new Covid19Data(region, aldersgruppe, beKræftedeTilfælde, døde, indlagtePåIntensiv, indlagte);
                        covid19List.add(covid19Data);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        for (Covid19Data covid19Data : covid19List) {
            System.out.println(covid19Data);

        }
    }

}