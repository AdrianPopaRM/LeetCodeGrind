package main.java.dev.arrays;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
        public int characterReplacement(String s, int k) {
    //        if (s.length() == 1) {
    //            return 1;
    //        }
            int left=0, longestLength=1;

            for(int i=1;i<s.length();i++){
                if(mostRepeatingCharInString(s.substring(left,i+1))+k>=i+1-left){
                    longestLength= Math.max(longestLength, i + 1 - left);
                }
                else{
                    left++;
                }
            }
            return longestLength;
        }
        private int mostRepeatingCharInString(String s){
            Map<Character, Integer> m = new HashMap<>();
            for(int i=0;i<s.length();i++){
                m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0)+1);
            }
            return Collections.max(m.values());
        }
}
