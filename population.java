
import java.util.Arrays;  
import java.util.Random;

public class population{
    snp[] possibleSnps;
    organism[] basePop; //starting population 
    organism[] fullPop;
    Random rand = new Random();
    int i;
    //creates a random population and simulates evoltion perhaps with some analysis methods 
    public population(int n,int m){//num organism, chomosome size
        this.possibleSnps = initSnps(m); // initialize random snps for this population
        this.basePop = new organism[n];
        for(i=0;i<n;i++){ //create n random organisms
            this.basePop[i] = new organism(m,this.possibleSnps);
        
        }
        this.fullPop = this.basePop;
    } 

    private snp[] initSnps(int m){ //create array of random snps (length 2m)
        Random rand = new Random();
        snp[] possibleSnps = new snp[2*m];

        for(i=0;i<2*m;i++)
            possibleSnps[i] = new snp();

        return possibleSnps;
    }

    public organism[] newGeneration(int k){ //create k new organisms to form 1 new generation
        orgainism[] nextGen = new [k];
        int A;
        int B;
        for(i=0;i<k;i++){
            //choose two random parents
            A = rand.nextInt(k); 
            B = rand.nextInt(k); 
            while(B==A)
                B = rand.nextInt(k);
            
            nextGen[i] = new orgainism(this.fullPop[A],this.fullPop[B])
        }
        return nextGen
    }
    
    public void reproduce(int gens){ //simulate multiple generations of reproduction 

    }

    public organism[] getPop(){
        return this.basePop;
    }

    public static void main(String[] args){
        organism[] test;
        population testPop = new population(10,3); 
        test = testPop.getPop();
        System.out.println(Arrays.toString(test));
    
    }
}