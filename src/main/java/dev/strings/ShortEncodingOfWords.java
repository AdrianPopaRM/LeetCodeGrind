package main.java.dev.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//A valid encoding of an array of words is any reference string s and array of indices indices such that:
//
//words.length == indices.length
//The reference string s ends with the '#' character.
//For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
//
//Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
//
//
//
//        Example 1:
//
//Input: words = ["time", "me", "bell"]
//Output: 10
//Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
//words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
//words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
//words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
//
//Example 2:
//
//Input: words = ["t"]
//Output: 2
//Explanation: A valid encoding would be s = "t#" and indices = [0].
//
//
//
//Constraints:
//
//        1 <= words.length <= 2000
//        1 <= words[i].length <= 7
//words[i] consists of only lowercase letters.


public class ShortEncodingOfWords {

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

    public static void main(String args[]){
        ShortEncodingOfWords test = new ShortEncodingOfWords();
        System.out.println(test.minimumLengthEncoding(new String[]{"time","bell","mee","me"}));
    }
}
