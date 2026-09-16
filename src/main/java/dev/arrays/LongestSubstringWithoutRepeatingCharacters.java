package main.java.dev.arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        switch (s.length()){
            case 0:
                return 0;
            case 1:
                return 1;
        }
        int maxLength=1;
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
//            currentString=stringBuilder.toString();
            if(stringBuilder.toString().indexOf(s.charAt(i))==-1){
                stringBuilder.append(s.charAt(i));
            }
            else{
                stringBuilder.delete(0,stringBuilder.indexOf(String.valueOf(s.charAt(i)))+1);
                stringBuilder.append(s.charAt(i));
            }
            maxLength = Math.max(stringBuilder.length(), maxLength);
        }
        return maxLength;
    }
}
