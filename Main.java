import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
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
    public static void main(String[] args) {
        population pop = new population(200, 100);
    }
}
