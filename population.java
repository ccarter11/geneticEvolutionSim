import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class population{
    snp[] possibleSnps;
    public organism[] randomFirstGeneration;
    Random rand = new Random();
    int i;
    ArrayList<organism[]> generations = new ArrayList<organism[]>();
    //creates a random population and simulates evoltion perhaps with some analysis methods 
    public population(int n, int m, snp[] possibleSnps){//number of organisms n, chromosome size m
        this.possibleSnps = possibleSnps;
        this.randomFirstGeneration = new organism[n]; //main population for instance
        System.out.println("possibleSnps and randomFirstGeneration initialized");

        for(i=0;i<n;i++){ //create n random organisms
            System.out.println("creating organism #" + i);

            HashMap<Integer, snp.expressedSnp> usedSnps = 
            new HashMap<Integer, snp.expressedSnp>();

            int position = rand.nextInt(possibleSnps.length);
            //position of currently examined snp

            int snpAmount = 0;

            snp.expressedSnp[] expressions = new snp.expressedSnp[2 * m];
            int expressionsCurrentIndex = 0;

            while (snpAmount < 2 * m) {
                position = rand.nextInt(possibleSnps.length);
                System.out.println("finding a new snp to add");
                if (usedSnps.get(position) == null) {
                    snp.expressedSnp positionSnp = 
                    possibleSnps[position].new expressedSnp(rand.nextInt(101));
                    usedSnps.put(position, positionSnp);

                    expressions[expressionsCurrentIndex] = positionSnp;
                    expressionsCurrentIndex+=1;

                    System.out.println("snp added");

                    snpAmount+=1;
                }
            }
            this.randomFirstGeneration[i] = new organism(m, expressions);
        }
    } 

    public population(organism[] foundingPop){
        this.generations.add(foundingPop);
    }

    public organism[] newGeneration(int k){ //create k new organisms to form 1 new generation
        organism[] nextGen = new organism[k];
        int A;
        int B;
        int genA;
        int genB;
        for(i=0;i<k;i++){
            //choose two random parents
            genA = rand.nextInt(generations.size());  
            genB = rand.nextInt(generations.size()); 
            A = rand.nextInt(generations.get(genA).length);
            B = rand.nextInt(generations.get(genB).length);

            if (genA == genB){ //make sure parents aren't the same organism
                while(B==A)
                    B = rand.nextInt(generations.get(genB).length);
            }
            A = rand.nextInt(k); 
            B = rand.nextInt(k); 
            while(B==A)
                B = rand.nextInt(k);
            nextGen[i] = new organism(randomFirstGeneration[A], randomFirstGeneration[B]);
        }
        return nextGen;
    }

    // public void reproduce(int gens){ //simulate multiple generations of reproduction 

    // }

    public ArrayList<organism[]> getGenerations() {
        return generations;
    }
}
    
