import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean solve(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> word1=new HashMap<>();
        Map<Character,Integer> word2=new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character currentChar= s.charAt(i);
            if(!word1.containsKey(currentChar)){
                word1.put(currentChar, 1);
            }
            else{
                word1.replace(currentChar, word1.get(currentChar)+1);
            }
        }
        for(int i=0; i<t.length(); i++){
            Character currentChar= t.charAt(i);
            if(!word2.containsKey(currentChar)){
                word2.put(currentChar, 1);
            }
            else{
                word2.replace(currentChar, word2.get(currentChar)+1);
            }
        }
        for(Character c: word2.keySet()){
            if(!word1.containsKey(c)||!word2.get(c).equals(word1.get(c))){
                return false;
            }
        }
        return true;
    }
}
