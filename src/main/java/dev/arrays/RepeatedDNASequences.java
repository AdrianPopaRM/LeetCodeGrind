package main.java.dev.arrays;

import java.lang.reflect.Array;
import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<11){
            return List.of();
        }
        Map<String,Integer> dnaMap = new HashMap<>();
        Set<String> result = new HashSet<>();
        for(int i=0;i<s.length()-9; i++){
            String currentSequence = s.substring(i,i+10);
            if(dnaMap.get(currentSequence)!=null){
                result.add(currentSequence);
            }
            else{
                dnaMap.put(currentSequence,1);
            }
        }
        return new ArrayList<>(result);
    }
    public static void main(String args[]){
//        RepeatedDNASequences test = new RepeatedDNASequences();
//        String s1 = "TTTGTTTTTTTTTTTTTTTGTTTTTCTGCGCGGTTTTTTTCTGCGCGGTTTTTTTTTTTTTTTATTTTTTGTTT";
//        List<String> result = test.findRepeatedDnaSequences(s1);
//        System.out.print("[");
//        for(String sequence : result.reversed()){
//            System.out.print("\""+sequence+"\""+",");
//        }
//        System.out.print("]");

    }
}
