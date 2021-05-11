package part1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


public class calculateDistance {

    public static int correctPredictions = 0;

    //K-value is set to 1 neighbour
    public static int k = 1;

    public static ArrayList<wineInstance> trainingAttributes = new ArrayList<wineInstance>();
    public static List<wineInstance> testAttributes = new ArrayList<wineInstance>();
    public static List<Distance> test = new ArrayList<Distance>();
    public static List<String> labels = new ArrayList<String>(Arrays.asList("Alcohol", "MalicAcid", "Ash", "AshAlcalinity", "Magnesium", "TotalPhenols", "Flavanoids",
                                                                            "NonFlavanoidPhenols", "Proanthocyanins", "ColorIntensity", "Hue", "DilutedWinesOD", "Proline"));


    public static void getDistance() throws FileNotFoundException {
        trainingAttributes = readFile.getTrainingList();
        testAttributes = readFile.getTestingList();

       // File file = new File("sampleoutput.txt");
      //  file.getParentFile().mkdirs();

        PrintWriter pw=  new PrintWriter("sampleoutput.txt");

        int iteration = 0;

        for(wineInstance i : trainingAttributes){
            List<Distance> distance = new ArrayList<Distance>();
            double d = 0.0;

            for(wineInstance j : testAttributes){
                distance.add(euclideanDistance(i,j));

            }




            Collections.sort(distance, new DistanceComparator());
            //System.out.println(distance);
            //System.out.println(distance.size());




            //get your k neighbours from distance
            double[] s = new double[k];

            for(int c = 0; c < k; c++) {
                s[c] = distance.get(c).distance;
            }
            //get the class for each of those neighbours
            //see which class occurs the most, possibly call getDistClass method
            //return distClass

            d = getDistClass(distance, s);

            //System.out.println("The dist class is: " + d);

            double testClass = 0.0;

            testClass = test.get(iteration).classNum2;
            //System.out.println("T = " + testClass);


            if(testClass == d){
                correctPredictions++;
                pw.println("The test class is: " + testClass);
                System.out.println("The test class is: " + testClass);
            }
            else{
                pw.println("The test class is: " + d);
                System.out.println("The test class is: " + d);
            }

            //System.out.println(correctPredictions);

            iteration++;

        }

        double accuracy = ((double)correctPredictions/trainingAttributes.size()) * 100;

        pw.println("Classification accuracy: " +  accuracy + "%");
        System.out.println("Classification accuracy: " +  accuracy + "%");

        pw.close();
        }



    public static double getDistClass(List<Distance> aList, double[] array){

        int one = 0;
        int two = 0;
        int three = 0;

        double distClass = 0.0;

        double[] s = new double[k];

        for(int i = 0; i < k; i++) {
            s[i] = aList.get(i).classNum;

                if (s[i] == 1.0) {
                    one++;
                }
                if (s[i] == 2.0) {
                    two++;
                }
                if (s[i] == 3.0){
                    three++;
                }
            }

        //System.out.println("One = " + one);
        //System.out.println("Two = " + two);
        //System.out.println("Three = " + three);

            if ((one > two) && (one > three)) {
                distClass = 1.0;
            }
            if ((two > one) && (two > three)) {
                distClass = 2.0;
            }
            if ((three > one) && (three > two)) {
                distClass = 3.0;
            }
        return distClass;
        }

    public static Distance  euclideanDistance(wineInstance i, wineInstance j){

        double dist = 0.0;

        double alcRange = 0.0;
        double malicAcidRange = 0.0;
        double ashRange = 0.0;
        double ashAlRange = 0.0;
        double magRange = 0.0;
        double totalPhenolsRange = 0.0;
        double flavRange = 0.0;
        double nonFlavRange = 0.0;
        double proanthoRange = 0.0;
        double colorIntRange = 0.0;
        double hueRange = 0.0;
        double dilutedWinesRange = 0.0;
        double prolineRange = 0.0;


        for (String s : labels) {
            if (s.equals("Alcohol")) {
                alcRange = getRange(trainingAttributes, s);
            }
            if (s.equals("MalicAcid")) {
                malicAcidRange = getRange(trainingAttributes, s);
            }
            if (s.equals("Ash")) {
                ashRange = getRange(trainingAttributes, s);
            }
            if (s.equals("AshAlcalinity")) {
                ashAlRange = getRange(trainingAttributes, s);
            }
            if (s.equals("Magnesium")) {
                magRange = getRange(trainingAttributes, s);
            }
            if (s.equals("TotalPhenols")) {
                totalPhenolsRange = getRange(trainingAttributes, s);
            }
            if (s.equals("Flavanoids")) {
                flavRange = getRange(trainingAttributes, s);
            }
            if (s.equals("NonFlavanoidPhenols")) {
                nonFlavRange = getRange(trainingAttributes, s);
            }
            if (s.equals("Proanthocyanins")) {
                proanthoRange = getRange(trainingAttributes, s);
            }
            if (s.equals("ColorIntensity")) {
                colorIntRange = getRange(trainingAttributes, s);
            }
            if (s.equals("Hue")) {
                hueRange = getRange(trainingAttributes, s);
            }
            if (s.equals("DilutedWinesOD")) {
                dilutedWinesRange = getRange(trainingAttributes, s);
            }
            if (s.equals("Proline")) {
                prolineRange = getRange(trainingAttributes, s);
            }
        }

        double alcoholDist = (Math.pow(i.getAlcohol() - j.getAlcohol(), 2)) / (Math.pow(alcRange, 2));
        double malicAcidDist = (Math.pow(i.getMalicAcid() - j.getMalicAcid(), 2)) / (Math.pow(malicAcidRange, 2));
        double ashDist = (Math.pow(i.getAsh() - j.getAsh(), 2)) / (Math.pow(ashRange, 2));
        double ashAlDist = (Math.pow(i.getAshAlcalinity() - j.getAshAlcalinity(), 2)) / (Math.pow(ashAlRange, 2));
        double magDist = (Math.pow(i.getMagnesium() - j.getMagnesium(), 2)) / (Math.pow(magRange, 2));
        double totalPhenolsDist = (Math.pow(i.getTotalPhenols() - j.getTotalPhenols(), 2)) / (Math.pow(totalPhenolsRange, 2));
        double flavDist = (Math.pow(i.getFlavanoids() - j.getFlavanoids(), 2)) / (Math.pow(flavRange, 2));
        double nonFlavDist = (Math.pow(i.getNonFlavavnoidPhenols() - j.getNonFlavavnoidPhenols(), 2)) / (Math.pow(nonFlavRange, 2));
        double proanthoDist = (Math.pow(i.getProanthocyanins() - j.getProanthocyanins(), 2)) / (Math.pow(proanthoRange, 2));
        double colorIntDist = (Math.pow(i.getColorIntensity() - j.getColorIntensity(), 2)) / (Math.pow(colorIntRange, 2));
        double hueDist = (Math.pow(i.getHue() - j.getHue(), 2)) / (Math.pow(hueRange, 2));
        double dilutedWinesDist = (Math.pow(i.getDilutedWinesOD() - j.getDilutedWinesOD(), 2)) / (Math.pow(dilutedWinesRange, 2));
        double prolineDist = (Math.pow(i.getProline() - j.getProline(), 2)) / (Math.pow(prolineRange, 2));

        double classNum = i.classGet();
        double classNum2 = j.classGet();

        dist = Math.sqrt(alcoholDist + malicAcidDist + ashDist + ashAlDist + magDist + totalPhenolsDist + flavDist + nonFlavDist + proanthoDist +
                colorIntDist + hueDist + dilutedWinesDist + prolineDist);

        test.add(new Distance(dist, classNum, classNum2));

        return new Distance(dist, classNum, classNum2);

    }

   public static double getRange(ArrayList<wineInstance> aList, String attribute){

        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;


        if(!aList.isEmpty()){

            for(wineInstance w : aList){
                if(attribute.equals("Alcohol")){ max = Math.max(max, w.getAlcohol()); min = Math.min(min, w.getAlcohol()); }
                if(attribute.equals("MalicAcid")){ max = Math.max(max, w.getMalicAcid()); min = Math.min(min, w.getMalicAcid()); }
                if(attribute.equals("Ash")){ max = Math.max(max, w.getAsh()); min = Math.min(min, w.getAsh()); }
                if(attribute.equals("AshAlcalinity")){ max = Math.max(max, w.getAshAlcalinity()); min = Math.min(min, w.getAshAlcalinity()); }
                if(attribute.equals("Magnesium")){ max = Math.max(max, w.getMagnesium()); min = Math.min(min, w.getMagnesium()); }
                if(attribute.equals("TotalPhenols")){ max = Math.max(max, w.getTotalPhenols()); min = Math.min(min, w.getTotalPhenols()); }
                if(attribute.equals("Flavanoids")){ max = Math.max(max, w.getFlavanoids()); min = Math.min(min, w.getFlavanoids()); }
                if(attribute.equals("NonFlavanoidPhenols")){ max = Math.max(max, w.getNonFlavavnoidPhenols()); min = Math.min(min, w.getNonFlavavnoidPhenols()); }
                if(attribute.equals("Proanthocyanins")){ max = Math.max(max, w.getProanthocyanins()); min = Math.min(min, w.getProanthocyanins()); }
                if(attribute.equals("ColorIntensity")){ max = Math.max(max, w.getColorIntensity()); min = Math.min(min, w.getColorIntensity()); }
                if(attribute.equals("Hue")){ max = Math.max(max, w.getHue()); min = Math.min(min, w.getHue()); }
                if(attribute.equals("DilutedWinesOD")){ max = Math.max(max, w.getDilutedWinesOD()); min = Math.min(min, w.getDilutedWinesOD()); }
                if(attribute.equals("Proline")){ max = Math.max(max, w.getProline()); min = Math.min(min, w.getProline()); }
            }
        }
        return max - min;
   }


    static class Distance {
        double distance;
        double classNum;
        double classNum2;

        public Distance(double distance, double classNum, double classNum2){
            this.distance = distance;
            this.classNum = classNum;
            this.classNum2 = classNum2;
        }

        @Override
        public String toString() {
            return "Distance{" +
                    "distance=" + distance +
                    ", classNum=" + classNum +
                    ", classNum2=" + classNum2 +
                    '}';
        }
    }

    static class DistanceComparator implements Comparator<Distance> {
        public int compare(Distance a, Distance b) {
           return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
        }
    }

}
