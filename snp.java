import java.util.Random;

public class snp{ //stores any nescessary info about each snp including possible variants and associated probabilities
    String[] variants;
    Random rand = new Random();
    int prob;
    int i;
    public snp(int prob, int index1, int index2){
        String[] nts = {"A","G","C","T"};
        this.variants = new String[2]; 
        this.variants[0] = nts[index1];
        this.variants[0] = nts[index2];
        this.prob = prob;

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

    class expressedSnp {
        int expressedIndex;
        public expressedSnp(int randomint) {
            if (randomint>prob) {
                expressedIndex=1;
            } else {
                expressedIndex=0;
            }
        }
    }
}