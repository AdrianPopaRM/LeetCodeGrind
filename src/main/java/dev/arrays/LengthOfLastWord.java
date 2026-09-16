package main.java.dev.arrays;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int indexLastWordLastChr=s.length()-1, indexLastWordFirstChr;
        while(indexLastWordLastChr>=0 && s.charAt(indexLastWordLastChr)==' '){
            indexLastWordLastChr--;
        }
        indexLastWordFirstChr=indexLastWordLastChr-1;
        while(indexLastWordFirstChr>=0 && s.charAt(indexLastWordFirstChr)!=' '){
            indexLastWordFirstChr--;
        }
        int lastWordLength= indexLastWordLastChr-indexLastWordFirstChr+1;
        return Math.max(lastWordLength, 0);
    }
}
