import java.util.Random;
public class organism{
    String [] chrA; 
    String [] chrB;
    Random rand = new Random();
    String nt;
    int j;
    int i;
    // create base pop orgainism
    public organism(int m, snp[] snps){ //chrom size, possible snps
        this.chrA = new String[m]; // nt,origin
        this.chrB = new String[m];
        for(i=0;i<m;i++){//add to chrA
            nt = snps[i].choose();
            this.chrA[i] = nt + ','+ Integer.toString(i); //incase we need to reference the snp object later but the order has gotten messed up
        }
        for(i=m;i<2*m;i++){//add to chrB 
            nt = snps[i].choose();
            this.chrB[i-m] = nt + ','+ Integer.toString(i);
        }
    }
    //create organism from parents 
    public organism(organism parentA, organism parentB){ 
        int m = parentA.getChrA().length;
        this.chrA = new String[m];
        this.chrB = new String[m];
        for( i=0;i<m;i++){//add to chr A 
            j = rand.nextInt(2);
            if(j==0){//choose from parent chr A 
                 this.chrA[i] = parentA.getChrA()[i];
            }else{
                this.chrA[i] = parentA.getChrB()[i];
            }
        }
        for(i=0;i<m;i++){//add to chrB 
            j = rand.nextInt(2);
            if(j==0){//choose from parent chr A 
                 this.chrB[i] = parentB.getChrA()[i];
            }else{
                this.chrB[i] = parentB.getChrB()[i];
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