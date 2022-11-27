import java.util.Arrays;  
import java.util.Random;

public class population{
    snp[] possibleSnps;
    organism[] organismPop;
    Random rand = new Random();
    int i;
    //creates a random population and simulates evoltion perhaps with some analysis methods 
    public population(int n,int m){//number of organisms n, chromosome size m
        this.possibleSnps = initSnps(2*m); // initialize random snps for this population
        this.organismPop = new organism[n]; //main population for instance
        snp.expressedSnp[] expressions = new snp.expressedSnp[2*m]; //array for expressed snps
        int choice = rand.nextInt(100); //expression index
        for (i=0;i<2*m;i++){
            //assign the possible snps to expressedSnps using the choice variable
            expressions[i] = possibleSnps[i].new expressedSnp(choice);
        }
        for(i=0;i<n;i++){ //create n random organisms
            this.organismPop[i] = new organism(m, expressions);
        }
    } 

    private snp[] initSnps(int m){ //create array of random snps (length 2m)
        snp[] possibleSnps = new snp[2*m];

        /*
        for(i=0;i<2*m;i++)
            possibleSnps[i] = new snp();
        */

        return possibleSnps;
    }

    public organism[] newGeneration(int k){ //create k new organisms to form 1 new generation
        organism[] nextGen = new organism[k];
        int A;
        int B;
        for(i=0;i<k;i++){
            //choose two random parents
            A = rand.nextInt(k); 
            B = rand.nextInt(k); 
            while(B==A)
                B = rand.nextInt(k);
            
            nextGen[i] = new organism(organismPop[A], organismPop[B]);
        }
        return nextGen;
    }
    
    public void reproduce(int gens){ //simulate multiple generations of reproduction 

    }

    public organism[] getPop(){
        return this.organismPop;
    }

    public static void main(String[] args){
        organism[] test;
        population testPop = new population(10,3); 
        test = testPop.getPop();
        System.out.println(Arrays.toString(test));
    
    }
}