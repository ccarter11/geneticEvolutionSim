import java.util.Random;


public class snp{ //stores any nescessary info about each snp including possible variants and associated probabilities
    String[] variants;
    Random rand = new Random();
    int prob;
    int i;
    public snp(){
        String[] nts = {"A","G","C","T"};
        this.variants = new String[2]; 
        for(i=0;i<2;i++){//choose two out of AGTC 
            int x = rand.nextInt(4);
            this.variants[i] = nts[x];
        }

        this.prob =1+ rand.nextInt(9); // determine prob of first variant . 10-90 % 

    }

    public String choose(){ //choose one of the variants based on associated probs 
        int choice = rand.nextInt(100); 
        String variant;

        if(choice - this.prob <= 0){ //apply associated probability 
            variant = this.variants[0];
        }else{
            variant=this.variants[1];
        }
        return variant;
    }



    public int getProb(){
        return this.prob; 
    }

    public String[] getVariants(){
        return this.variants; 
    }
    
}