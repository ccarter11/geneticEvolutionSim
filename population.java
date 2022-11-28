import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class population{
    snp[] possibleSnps;
    organism[] randomFirstGeneration;
    Random rand = new Random();
    int i;
    ArrayList<organism[]> generations = new ArrayList<organism[]>();
    //creates a random population and simulates evoltion perhaps with some analysis methods 
    public population(int n, int m, snp[] possibleSnps){//number of organisms n, chromosome size m
        this.possibleSnps = possibleSnps;
        this.randomFirstGeneration = new organism[n]; //main population for instance

        for(i=0;i<n;i++){ //create n random organisms

            HashMap<Integer, snp.expressedSnp> usedSnps = 
            new HashMap<Integer, snp.expressedSnp>();

            int position = rand.nextInt(possibleSnps.length);

            int snpAmount = 0;

            snp.expressedSnp[] expressions = new snp.expressedSnp[2 * m];
            int expressionsCurrentIndex = 0;

            while (snpAmount < 2 * m) {
                if (usedSnps.get(position) == null) {
                    snp.expressedSnp positionSnp = 
                    possibleSnps[position].new expressedSnp(rand.nextInt(101));
                    usedSnps.put(position, positionSnp);

                    expressions[expressionsCurrentIndex] = positionSnp;
                    expressionsCurrentIndex+=1;

                    snpAmount+=1;
                }
            }
            this.randomFirstGeneration[i] = new organism(m, expressions);
        }
    } 

    public population(organism[] foundingPop){
        this.generations.add(foundingPop);
    }

    public organism[] newGeneration(int k){ //create k new organisms to form previous generation
        organism[] nextGen = new organism[k];
        int A;
        int B;
        int genIdx;
        for(i=0;i<k;i++){
            //choose two random parents
            genIdx = this.generations.size() - 1;
            A = rand.nextInt(generations.get(genIdx).length);
            B = rand.nextInt(generations.get(genIdx).length);
  
            while(B==A)//make sure parents aren't the same organism
                B = rand.nextInt(generations.get(genIdx).length);
            nextGen[i] = new organism(generations.get(genIdx)[A], generations.get(genIdx)[B]);
        }
        return nextGen;
    }
    
    public void reproduce(int gens, int genSize){ //simulate multiple generations of reproduction 
        for(i=0;i<gens;i++) 
            this.generations.add(newGeneration(genSize));
    }

    public ArrayList<organism[]> getGenerations() {
        return generations;
    }
}
    
