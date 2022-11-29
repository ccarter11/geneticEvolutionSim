import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static Random rand = new Random();
    public static int genSize = 10;
    public static int chromSize = 100;

    public static void writePopToFile(population pop, String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        ArrayList<organism[]> generations = pop.getGenerations();
        for (int genIndex = generations.size()-1; genIndex >= 0; genIndex--) {
            fw.write("Generation: " + Integer.toString(generations.size()-genIndex) +"\n");
            for (int orgIndex = 0; orgIndex < generations.get(genIndex).length; orgIndex++) {

                fw.write("\nOrganism: " + Integer.toString(orgIndex) + "\nChromosome A\n");

                snp.expressedSnp[] chromA = generations.get(genIndex)[orgIndex].getChrA();
                for (int snpIndex = 0; snpIndex < chromA.length; snpIndex++) {
                    fw.write(chromA[snpIndex].expressedVariant + ", ");
                }

                fw.write("\nChromosome B\n");

                snp.expressedSnp[] chromB = generations.get(genIndex)[orgIndex].getChrB();
                for (int snpIndex = 0; snpIndex < chromB.length; snpIndex++) {
                    fw.write(chromB[snpIndex].expressedVariant + ", ");
                }
            }
            fw.write("\n\n");
        }
        fw.close();
    }

    public static void comparePops() {

    }

    public static Boolean isBottleneck(population originalPop, population examinedPop) {
        Boolean isBottleneck = false;



        return isBottleneck;
    }

    // public static population bottleNeck(popA,popB,remainingOrganisms){
        
    // }

    // public static population founderEffect(popA, remainingOrganisms){

    // }

    public static snp[] initSnps(int m) {
        snp[] possibleSnps = new snp[m];
        for(int i = 0; i < m; i++) {
            possibleSnps[i] = new snp(rand.nextInt(101), 
            rand.nextInt(4),
            rand.nextInt(4));
            possibleSnps[i].setPosition(i);
        }
        return possibleSnps;
    }

    public static void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-n")) {
                //generation size, default=10
                genSize = Integer.parseInt(args[i+1]);
            } 
            else if (args[i].equals("-m")) {
                //chromosome size, default=100
                chromSize = Integer.parseInt(args[i+1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {


        snp[] possibleSnps1 = initSnps(400);
        System.out.println("possibleSnps1 initialized");
        population populationA = new population(10, 100, possibleSnps1);
        System.out.println("populationA initialized");
        population populationB = new population(10, 100, possibleSnps1);
        System.out.println("populationB initialized");

        for (int i = 0; i < populationA.randomFirstGeneration.length; i++) {
            System.out.println(populationA.randomFirstGeneration[i].chrA[0]);
        }
        
        //initial evolution
        populationB.reproduce(11, 10);
        populationA.reproduce(8, 10);
        //bottleneck effect on population A
        populationA.bottleNeck(4);
        populationA.reproduce(2, 10);

        writePopToFile(populationB, "popB.txt");
        writePopToFile(populationA, "popA.txt");

        System.out.println("generations");
        for (int i = 0; i < populationA.generations.size(); i++) {
            System.out.println(populationA.generations.get(i)[0].getChrA()[0]);
        }
    }
}

