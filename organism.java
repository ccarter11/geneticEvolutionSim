import java.util.Random;
public class organism{
    String [] chrA; 
    String [] chrB;
    Random rand = new Random();
    int j;
    int i;
    // create base pop orgainism
    public organism(int m, snp.expressedSnp[] snps){ //chrom size, possible snps
        this.chrA = new String[m];
        this.chrB = new String[m];
        for(i=0;i<m;i++){//add to chrA
            this.chrA[i] = snps[i].expressedVariant;
        }
        for(i=m;i<2*m;i++){//add to chrB 
            this.chrB[i-m] = snps[i].expressedVariant;
        }
    }
    //create organism from parents 
    public organism(organism daddy, organism mommy){ 
        int m = daddy.getChrA().length;
        this.chrA = new String[m];
        this.chrB = new String[m];
        for( i=0;i<m;i++){//add to chr A 
            j = rand.nextInt(2);
            if(j==0) {//choose from parent chr A 
                 this.chrA[i] = daddy.getChrA()[i];
            } else {
                this.chrA[i] = daddy.getChrB()[i];
            }
        }
        for(i=0;i<m;i++){//add to chrB 
            j = rand.nextInt(2);
            if(j==0){//choose from parent chr A 
                 this.chrB[i] = mommy.getChrA()[i];
            }else{
                this.chrB[i] = mommy.getChrB()[i];
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