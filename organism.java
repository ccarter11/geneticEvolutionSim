import java.util.Random;
public class organism{
    snp.expressedSnp [] chrA; 
    snp.expressedSnp [] chrB;
    Random rand = new Random();
    int j;
    int i;
    // create base pop orgainism
    public organism(int m, snp.expressedSnp[] snps){ //chrom size, possible snps
        this.chrA = new snp.expressedSnp[m];
        this.chrB = new snp.expressedSnp[m];
        for(i=0;i<m;i++){//add to chrA
            this.chrA[i] = snps[i];
        }
        for(i=m;i<2*m;i++){//add to chrB 
            this.chrB[i-m] = snps[i];
        }
    }
    //create organism from parents 
    public organism(organism daddy, organism mommy){ 
        int m = daddy.getChrA().length;
        this.chrA = new snp.expressedSnp[m];
        this.chrB = new snp.expressedSnp[m];
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

    public snp.expressedSnp[] getChrA(){
        return this.chrA;
    }
    public snp.expressedSnp[] getChrB(){
        return this.chrB;
    }
}