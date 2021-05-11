package part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readFile {

    public static List<wineInstance> trainingAttributes = new ArrayList<wineInstance>();
    public static List<wineInstance> testAttributes = new ArrayList<wineInstance>();

    public static void readTrainingSet(String filename) throws IOException, NumberFormatException {
        File train = new File((filename));

        try {
            BufferedReader readTrainFile = new BufferedReader(new FileReader(train));

            readTrainFile.readLine();
            String line;

            while ((line = readTrainFile.readLine()) != null) {

                String[] split = line.split(" ");

                wineInstance instance = new wineInstance();

                instance.Alcohol = Double.parseDouble(split[0]);
                instance.MalicAcid = Double.parseDouble(split[1]);
                instance.Ash = Double.parseDouble(split[2]);
                instance.AshAlcalinity = Double.parseDouble(split[3]);
                instance.Magnesium = Double.parseDouble(split[4]);
                instance.TotalPhenols = Double.parseDouble(split[5]);
                instance.Flavanoids = Double.parseDouble(split[6]);
                instance.NonFlavavnoidPhenols = Double.parseDouble(split[7]);
                instance.Proanthocyanins = Double.parseDouble(split[8]);
                instance.ColorIntensity = Double.parseDouble(split[9]);
                instance.Hue = Double.parseDouble(split[10]);
                instance.DilutedWinesOD = Double.parseDouble(split[11]);
                instance.Proline = Double.parseDouble(split[12]);
                instance.Class = Double.parseDouble(split[13]);

                trainingAttributes.add(instance);
            }

            //System.out.println(trainingAttributes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readTestingSet(String filename) throws IOException, NumberFormatException {
        File test = new File((filename));

        try {
            BufferedReader readTestFile = new BufferedReader(new FileReader(test));

            readTestFile.readLine();
            String line;

            while ((line = readTestFile.readLine()) != null) {

                String[] split = line.split(" ");

                wineInstance instance2 = new wineInstance();

                instance2.Alcohol = Double.parseDouble(split[0]);
                instance2.MalicAcid = Double.parseDouble(split[1]);
                instance2.Ash = Double.parseDouble(split[2]);
                instance2.AshAlcalinity = Double.parseDouble(split[3]);
                instance2.Magnesium = Double.parseDouble(split[4]);
                instance2.TotalPhenols = Double.parseDouble(split[5]);
                instance2.Flavanoids = Double.parseDouble(split[6]);
                instance2.NonFlavavnoidPhenols = Double.parseDouble(split[7]);
                instance2.Proanthocyanins = Double.parseDouble(split[8]);
                instance2.ColorIntensity = Double.parseDouble(split[9]);
                instance2.Hue = Double.parseDouble(split[10]);
                instance2.DilutedWinesOD = Double.parseDouble(split[11]);
                instance2.Proline = Double.parseDouble(split[12]);
                instance2.Class = Double.parseDouble(split[13]);

                testAttributes.add(instance2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<wineInstance> getTrainingList() {
        return (ArrayList<wineInstance>) trainingAttributes;
    }

    public static ArrayList<wineInstance> getTestingList() {
        return (ArrayList<wineInstance>) testAttributes;
    }

}
