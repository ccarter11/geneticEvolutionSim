import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

public class Main {

    public static Random rand = new Random();
    public static int genSize = 40;
    public static int chromSize = 20; 


    public static void writePopToFile(population pop, String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        ArrayList<organism[]> generations = pop.getGenerations();
        for (int genIndex = generations.size()-1; genIndex >= 0; genIndex--) {
            fw.write("Generation: " + Integer.toString(generations.size()-genIndex) +"\n");
            for (int orgIndex = 0; orgIndex < generations.get(genIndex).length; orgIndex++) {

                fw.write("\nOrganism: " + Integer.toString(orgIndex) + "\nChromosome A\n");

                snp.expressedSnp[] chromA = generations.get(genIndex)[orgIndex].getChrA();
                for (int snpIndex = 0; snpIndex < chromA.length; snpIndex++) {
                    fw.write(chromA[snpIndex].expressedVariant + " "+chromA[snpIndex].position+", ");
                }

                fw.write("\nChromosome B\n");

                snp.expressedSnp[] chromB = generations.get(genIndex)[orgIndex].getChrB();
                for (int snpIndex = 0; snpIndex < chromB.length; snpIndex++) {
                    fw.write(chromB[snpIndex].expressedVariant + " "+chromB[snpIndex].position+ ", ");
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

    public static void analyzeDiversity(population popA, population popB){ 
        //compare snps from PopA and PopB

        HashMap<Integer, Boolean> snpsInA = new HashMap<Integer, Boolean>(); //False means in popA but not B, True means in both
        HashMap<Integer, Boolean> snpsInB = new HashMap<Integer, Boolean>(); 
        
        int inBnotA = 0; 
        int inAnotB = 0 ;

        //populate hashtables for all snps in pop a and b

        organism[] organismsInA = popA.generations.get(0);
        organism[] organismsInB = popB.generations.get(0);
        for (int i = 0; i < genSize; i++) {
            for (int j = 0; j < chromSize; j++) {
                snpsInA.put(organismsInA[i].getChrA()[j].position, false);
                snpsInB.put(organismsInB[i].getChrA()[j].position, false);
            }
            for (int j = 0; j < chromSize; j++) {
                snpsInA.put(organismsInA[i].getChrB()[j].position, false);
                snpsInB.put(organismsInB[i].getChrB()[j].position, false);
            }
            
        }
        System.out.println("C: " + snpsInA.keySet() +'\n');
        System.out.println("D: " + snpsInB.keySet() +'\n');

        HashMap<Integer, Boolean> checkedFromB = new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> checkedFromA = new HashMap<Integer, Boolean>();

        for (int i = 0; i < genSize; i++) {
            for (int j = 0; j < chromSize; j++) {

                //in B not A section
                if (checkedFromB.get(organismsInB[i].getChrA()[j].position) == null) {
                    checkedFromB.put(organismsInB[i].getChrA()[j].position, true);

                    System.out.println("snp: " 
                    + Integer.toString(organismsInB[i].getChrA()[j].position)
                    + " checked from popB");

                    if (snpsInA.get(organismsInB[i].getChrA()[j].position) == null) {
                        //if not in A
                        inBnotA++;
                    }
                }
                if (checkedFromB.get(organismsInB[i].getChrB()[j].position) == null) {
                    checkedFromB.put(organismsInB[i].getChrB()[j].position, true);

                    System.out.println("snp: " 
                    + Integer.toString(organismsInB[i].getChrB()[j].position)
                    + " checked from popB");

                    if (snpsInA.get(organismsInB[i].getChrB()[j].position) == null) {
                        //same for chromosome B
                        inBnotA++;
                    }
                }

                //in A not B section
                if (checkedFromA.get(organismsInA[i].getChrA()[j].position) == null) {
                    checkedFromA.put(organismsInA[i].getChrA()[j].position, true);

                    System.out.println("snp: " 
                    + Integer.toString(organismsInA[i].getChrA()[j].position)
                    + " checked from popA");

                    if (snpsInB.get(organismsInA[i].getChrA()[j].position) == null) {
                        //if not in A
                        inAnotB++;
                    }
                }
                if (checkedFromA.get(organismsInA[i].getChrB()[j].position) == null) {
                    checkedFromA.put(organismsInA[i].getChrB()[j].position, true);

                    System.out.println("snp: " 
                    + Integer.toString(organismsInA[i].getChrB()[j].position)
                    + " checked from popA");

                    if (snpsInB.get(organismsInA[i].getChrB()[j].position) == null) {
                        //same for chromosome B
                        inAnotB++;
                    }
                }
            }
        }
        
        
        // for(int i=0;i<organismsInA.length;i++){
        //     organism currOrg =  organismsInA[i] ;
        //     for(int j=0; j<2*chromSize;j++){// for each nt
        //         if(j<chromSize){ //access chrmA
        //             int snpId = currOrg.chrA[j].getSnp().position;
        //              if (snpsInA.get(snpId) == null){
        //                  snpsInA.put(snpId,false); //record presence of snp    
        //                  inAnotB++;
        //                 }
        //          }else{ 
        //              int snpId = currOrg.chrB[j-chromSize].getSnp().position;
        //              if (snpsInA.get(snpId) == null){
        //                   snpsInA.put(snpId,false); 
        //                  inAnotB++; 
        //              }
        //          }
        //     }
        // }
        // organism[] organismsB = popB.generations.get(0);
        // for(int i=0; i<organismsB.length;i++){
        //     organism currOrg =  organismsB[i] ;
        //     for(int j=0; j<2*chrmSize;j++){// for each nt
        //         if(j<chrmSize){ //access chrmA
        //             int snpId = currOrg.chrA[j].getSnp().position;
        //              if (snpsInA.get(snpId) != null){
        //                  snpsInA.put(snpId,true); //record presence of snp    
        //                  inAnotB--;
        //                 }
        //              else{
        //                  inBnotA++;
        //              }
        //          }else{ 
        //              int snpId = currOrg.chrB[j-chrmSize].getSnp().position;
        //              if (snpsInA.get(snpId) != null){
        //                   snpsInA.put(snpId,true); 
        //                  inAnotB--; 
        //              }else{
        //                  inBnotA++;
        //              }
        //          }
        //     }
        // }

        population founderPop = null;
        population bottleneckPop = null;
        population otherPop = null;

        if (inAnotB == 0 && inBnotA > 0) {
            founderPop = popB;
            otherPop = popA;
        }
        if (inBnotA == 0 && inAnotB > 0) {
            founderPop = popA;
            otherPop = popB;
        }

        if (inBnotA > 0 && inBnotA > 0) {
            //bottleneck effect
            if (inBnotA < inAnotB) {
                bottleneckPop = popB;
                otherPop = popA;
            } else if (inBnotA > inAnotB) {
                bottleneckPop = popA;
                otherPop = popB;
            }
        }

        if (bottleneckPop != null) {
            System.out.println("\n\n\nthe bottleneck effect took place in the created populations...\n\n\n");
            System.out.println("prediction: " + bottleneckPop.id + " was bottlenecked\n\n");
            System.out.println("prediction: " + otherPop.id + " was safe\n\n");
        } else if (founderPop != null) {
            System.out.println("\n\n\nthe founder effect took place in the created populations...\n\n\n");
            System.out.println("prediction: " + founderPop.id + " was a founder population\n\n");
            System.out.println("prediction: " + otherPop.id + " was stable\n\n");
        } else {
            System.out.println("\n\n\nno effect was found to have happend in any population\n\n\n");
        }
        System.out.println(Integer.toString(inAnotB));
        System.out.println(Integer.toString(inBnotA));
    //when set to true,subtract from in popAnotB
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
        snp[] possibleSnps1 = initSnps(50);
        // System.out.println("possibleSnps1 initialized");
         population populationA = new population(10, 20, possibleSnps1, "popA");
        // System.out.println("populationA initialized");
         population populationB = new population(10, 20, possibleSnps1, "popB");
        // System.out.println("populationB initialized");

        // for (int i = 0; i < populationA.randomFirstGeneration.length; i++) {
        //     System.out.println(populationA.randomFirstGeneration[i].chrA[0]);
        // }
        
        // //------ Bottleneck ------//
        //initial evolution
        populationB.reproduce(5, 40);
        populationA.reproduce(5, 40);
        //bottleneck effect on population A
        populationA.bottleNeck(4);
        populationA.reproduce(2, 40);
        


        writePopToFile(populationB, "popB.txt");
        writePopToFile(populationA, "popA.txt");

        System.out.println("generations");
        for (int i = 0; i < populationA.generations.size(); i++) {
            System.out.println(populationA.generations.get(i)[0].getChrA()[0]);
        }
        
        //------ Founder effect ------// 
        // population populationC = new population(10, 10, possibleSnps1, "popC");
        // populationC.reproduce(2, 5);
        // organism[] foundingPop = populationC.founderEffect(2);
        // population populationD = new population(foundingPop, "popD");
        // populationC.reproduce(1, 5);
        // populationD.reproduce(1,5);

        // writePopToFile(populationC, "popC.txt");
        // writePopToFile(populationD, "popD.txt");

        analyzeDiversity(populationA, populationB);
    }
}
