public class population{
    snp[] possibleSnps;
    organism[] pop;
    int i;
    //creates a random population and simulates evoltion perhaps with some analysis methods 
    public population(int n,int m){//num organism, chomosome size
        this.possibleSnps = initSnps(m); // initialize random snps for this population
        this.pop = new organism[n];
        for(i=0;i<n;i++){ //create n random organisms
            organism x = new organism(m,this.possibleSnps);
        }

        
        

    } 

    private snps[] initSnps(m){ //create array of random snps (length 2m)

    }

    public void reproduce(gens){ 

    }
}