import java.util.Arrays;  
import java.util.Random;
import java.util.ArrayList;

public class population{
    snp[] possibleSnps;
    organism[] randomFirstGeneration;
    Random rand = new Random();
    int i;
    ArrayList<organism[]> generations = new ArrayList<organism[]>() ;
    //creates a random population and simulates evoltion perhaps with some analysis methods 
    public population(int n,int m){//number of organisms n, chromosome size m
        possibleSnps = initSnps(2*m); // initialize random snps for this population
        this.randomFirstGeneration = new organism[n]; //main population for instance
        snp.expressedSnp[] expressions = new snp.expressedSnp[2*m]; //array for expressed snps
        int choice = rand.nextInt(100); //expression index
        for (i=0;i<2*m;i++){
            //assign the possible snps to expressedSnps using the choice variable
            expressions[i] = possibleSnps[i].new expressedSnp(choice);
        }
        for(i=0;i<n;i++){ //create n random organisms
            this.randomFirstGeneration[i] = new organism(m, expressions);
        }
        this.generations.add(randomFirstGeneration);
    } 

    public population(organism[] foundingPop){
        this.generations.add(foundingPop);
    }


    private snp[] initSnps(int m){ //create array of random snps (length 2m)
        snp[] possibleSnps = new snp[2*m];
        int index1 = rand.nextInt(4);
        int index2 = rand.nextInt(4);
        int prob = rand.nextInt(101);
        for(i=0;i<2*m;i++)
            possibleSnps[i] = new snp(prob, index1, index2);
        return possibleSnps;
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
    
