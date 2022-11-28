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

                fw.write("Organism: " + Integer.toString(orgIndex) + "\nChromosome A\n");

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
        int index1 = rand.nextInt(4);
        int index2 = rand.nextInt(4);
        int prob = rand.nextInt(101);
        for(int i = 0; i < m; i++) {
            possibleSnps[i] = new snp(prob, index1, index2);
            possibleSnps[i].setPosition(i);
        }
        return possibleSnps;
    }

    public static void main(String[] args) {
        snp[] possibleSnps1 = initSnps(10);
        population populationA = new population(10, 100, possibleSnps1);
        population populationB = new population(10, 100, possibleSnps1);
    }
}

