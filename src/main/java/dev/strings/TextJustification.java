package main.java.dev.strings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedText = new ArrayList<>();
        int nrCharsInCurrentSentence=0, minNrWhiteSpaces=0;
        Queue<String> currentSentence = new ArrayDeque<>();

        for(int i=0; i<words.length; i++){
            if(nrCharsInCurrentSentence + minNrWhiteSpaces + words[i].length() > maxWidth){
                justifiedText.add(buildJustifiedSentence(currentSentence, nrCharsInCurrentSentence, maxWidth,false));
                i--;
                nrCharsInCurrentSentence=0;
                minNrWhiteSpaces=0;
            }
            else{
                currentSentence.offer(words[i]);
                nrCharsInCurrentSentence+=words[i].length();
                minNrWhiteSpaces++;
            }

        }
        justifiedText.add(buildJustifiedSentence(currentSentence, nrCharsInCurrentSentence, maxWidth, true));
        return justifiedText;
    }
    private String buildJustifiedSentence(Queue<String> currentSentence, int nrCharsInCurrentSentence, int maxWidth, boolean isLastSentence){
        StringBuilder sentenceBuilder = new StringBuilder();
        int nrWords=currentSentence.size();
        if(nrWords==1){
            sentenceBuilder.append(currentSentence.peek());
            int wordSize=currentSentence.poll().length();
            for(int aux=0; aux<maxWidth-wordSize; aux++){
                sentenceBuilder.append(" ");
            }
        }
        else if(isLastSentence){
            for (int j = 0; j < nrWords; j++){
                sentenceBuilder.append(currentSentence.poll());
                if(j!=nrWords-1){
                    sentenceBuilder.append(" ");
                }
            }
            int nrOfRemainingWhiteSpaces = maxWidth - sentenceBuilder.length();
            for(int j = 0; j < nrOfRemainingWhiteSpaces; j++){
                sentenceBuilder.append(" ");
            }

        }else {
            int extraSpaces = (maxWidth - nrCharsInCurrentSentence) % (nrWords - 1);
            for (int j = 0; j < nrWords-1; j++) {
                sentenceBuilder.append(currentSentence.poll());

                if(extraSpaces!=0){
                    sentenceBuilder.append(" ");
                    extraSpaces--;
                }
                for (int aux = 0; aux < (maxWidth - nrCharsInCurrentSentence) / (nrWords - 1); aux++) {
                    sentenceBuilder.append(" ");
                }
            }
            sentenceBuilder.append(currentSentence.poll());
        }
        return sentenceBuilder.toString();
    }

    public static void main(String args[]){
        TextJustification test = new TextJustification();
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words2 = {"What","must","be","acknowledgment","shall","be"};
        String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        for(String sentence : test.fullJustify(words2,16)){
            System.out.println(sentence);
        }
//        System.out.println(test.fullJustify(words1,16));
//        System.out.println(test.fullJustify(words2,16));
//        System.out.println(test.fullJustify(words3,20));
    }
}
