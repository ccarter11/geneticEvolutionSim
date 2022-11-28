import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static Random rand = new Random();

    public static void writePopToFile(population pop, String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        ArrayList<organism[]> generations = pop.getGenerations();
        for (int genIndex = 0; genIndex < generations.size(); genIndex++) {
            fw.write("Generation: " + Integer.toString(genIndex) +"\n");
            for (int orgIndex = 0; orgIndex < generations.get(genIndex).length; orgIndex++) {

                fw.write("\nOrganism: " + Integer.toString(orgIndex) + "\nChromosome A\n");

                String[] chromA = generations.get(genIndex)[orgIndex].getChrA();
                for (int snpIndex = 0; snpIndex < chromA.length; snpIndex++) {
                    fw.write(chromA[snpIndex] + ", ");
                }

                fw.write("\nChromosome B\n");

                String[] chromB = generations.get(genIndex)[orgIndex].getChrB();
                for (int snpIndex = 0; snpIndex < chromB.length; snpIndex++) {
                    fw.write(chromB[snpIndex] + ", ");
                }
            }
        }
        fw.close();
    }

    public static void comparePops() {

    }

    public static Boolean isBottleneck(population originalPop, population examinedPop) {
        Boolean isBottleneck = false;



        return isBottleneck;
    }

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

        writePopToFile(populationB, "popB.txt");
        writePopToFile(populationA, "popA.txt");
    }
}

