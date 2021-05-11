package part1;
import java.io.*;
import java.util.Scanner;


public class K_NearestNeighbour {

    public static void main(String[] args) throws NumberFormatException, IOException{
        Scanner sc=new Scanner(System.in);

        System.out.println("\nK-Nearest Neighbour Implementation for Wine Dataset\n");

        System.out.println("Enter training dataset filename: ");
        String trainingSet = sc.nextLine();

        System.out.println("Enter test dataset filename: ");
        String testingSet = sc.nextLine();


        readFile.readTrainingSet(trainingSet);
        readFile.readTestingSet(testingSet);

        calculateDistance.getDistance();

    }
}



