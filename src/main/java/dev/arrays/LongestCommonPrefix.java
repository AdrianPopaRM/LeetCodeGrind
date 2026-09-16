package main.java.dev.arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix="";
        boolean end=false;
        int maxLength=strs[0].length();
        for(String s: strs){
            maxLength=Math.min(maxLength, s.length());
        }
        int length=1;
        while(length<=maxLength){
            boolean endLoop=false;
            String currentPrefix=strs[0].substring(0,length);
            for (String s:strs){
                if(!currentPrefix.equals(s.substring(0,length))){
                    endLoop=true;
                    break;
                }
            }
            if(endLoop){
                break;
            }
            longestPrefix=currentPrefix;
            length++;
        }
        return longestPrefix;
    }
    public static void main(String[] args){
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"a"};
        LongestCommonPrefix c= new LongestCommonPrefix();
//        System.out.println(c.longestCommonPrefix(strs1));;
        System.out.println(c.longestCommonPrefix(strs2));
    }
}

