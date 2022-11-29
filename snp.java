import java.util.Random;

public class snp{ //stores any nescessary info about each snp including possible variants and associated probabilities
    String[] variants;
    Random rand = new Random();
    int prob;
    int i;
    public int position;
    public snp(int prob, int index1, int index2) {
        String[] nts = {"A","G","C","T"};
        this.variants = new String[2];
        this.variants[0] = nts[index1];
        this.variants[1] = nts[index2];
        this.prob = prob;
    }

    public int getProb(){
        return this.prob; 
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

    public String[] getVariants(){
        return this.variants; 
    }

    class expressedSnp{
        int expressedIndex;
        String expressedVariant;
        int position;


        public expressedSnp(int randomint) {
            if (randomint>prob) {
                expressedIndex=1;
            } else {
                expressedIndex=0;
            }
            this.expressedVariant = variants[expressedIndex];

        }   

        public snp getSnp() {
            return snp.this;
        }
    }
}