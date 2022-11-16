import using java.util.Random;
public class organism{
    // create base pop orgainism
    public organism(int m, snp[] snps){ //chrom size, possible snps
        String [] this.chrA = new [m]; // nt,origin
        String [] this.chrB = new [m];
        for(int i=0;i<m;i++){//add to chrA
            String nt = snps[i].choose()
            this.chrA[i] = nt + ','+ Integer.toString(i) //incase we need to reference the snp object later but the order has gotten messed up
        }
        for(int i=m,i<2*m;i++){//add to chrB 
            String nt = snps[i].choose();
            this.chrB[i] = nt + ','+ Integer.toString(i);
        }
    }
    //create organism from parents 
    public orgainism(organism parentA, orgainism parentB){ 
        Random rand = new Random();
        int m = partentA.getChrA().length;
        String[] this.chrA = new [m];
        String[] this.chrB = new [m];
        for(int i=0;i<m;i++){//add to chr A 
            int j = rand.nextInt(2);
            if(j==0){//choose from parent chr A 
                 this.chrA[i] = parentA.getChrA();
            }else{
                this.chrA[i] = parentA.getChrB();
            }
        }
        for(int i=0;i<m;i++){//add to chrB 
            int j = rand.nextInt(2);
            if(j==0){//choose from parent chr A 
                 this.chrB[i] = parentB.getChrA();
            }else{
                this.chrB[i] = parentB.getChrB();
            }
           
        }
    }

    public String[] getChrA(){
        return this.chrA;
    }
    public String[] getChrB(){
        return this.chrB;
    }
}