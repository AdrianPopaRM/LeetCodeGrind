package main.java.dev.arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int hMax=0;
        int potentialH=1;
        while(potentialH<citations.length+1){
            int counter=0;
            for(int i=0;i<citations.length;i++){
                if(counter>=potentialH){
                    hMax=potentialH;
                    break;
                }
                if(citations[i]>=potentialH){
                    counter++;
                }
            }
            if(counter>=potentialH){
                hMax=potentialH;
            }
            potentialH++;
        }
        return hMax;
    }
}
