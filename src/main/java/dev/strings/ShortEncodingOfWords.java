package main.java.dev.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortEncodingOfWords {
    //    public int minimumLengthEncoding(String[] words) {
//        Map<Integer, ArrayList<String>> wordMap = new HashMap<>();
//        for(String word : words){
//            wordMap.computeIfAbsent(word.length(), key->new ArrayList<>()).add(word);
//        }
//        for(int i=1; i<=7;i++){
//            for(String currentWord : wordMap.get(i)){
//                for(int j=i+1; j<=7;j++){
//
//                }
//            }
//        }
//    }
    public int minimumLengthEncoding(String[] words) {
        Map<Integer, ArrayList<String>> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.computeIfAbsent(word.length(), key -> new ArrayList<>()).add(word);
        }
        StringBuilder result= new StringBuilder();
        for(int i=7;i>0;i--){
            if(wordMap.get(i)!=null){
                for (String currentWord : wordMap.get(i)) {
                    int indexOfOccurrence=0;

                    while(true){
                        indexOfOccurrence=result.indexOf(currentWord, indexOfOccurrence);
                        if(indexOfOccurrence==-1){
                            break;
                        }
                        else{
                            if(result.charAt(indexOfOccurrence+currentWord.length())!='#'){
                                indexOfOccurrence++;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if(indexOfOccurrence==-1){
                        result.append(currentWord).append("#");
                    }
                }
            }
        }
        return result.length();
    }
    public static void main(String args[]){
        ShortEncodingOfWords test = new ShortEncodingOfWords();
        System.out.println(test.minimumLengthEncoding(new String[]{"time","bell","mee","me"}));
    }
}
