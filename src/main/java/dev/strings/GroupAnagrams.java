package main.java.dev.strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> groupAnagrams = new HashMap<>();
        for(String word : strs){
            List<Character> characterList = new ArrayList<>();
            for(int i=0; i<word.length(); i++){
                characterList.add(word.charAt(i));
            }
            characterList.sort(Comparator.naturalOrder());
            groupAnagrams.computeIfAbsent(characterList, k-> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groupAnagrams.values());
    }
    //Time it took to solve: 12.06 mins
}
