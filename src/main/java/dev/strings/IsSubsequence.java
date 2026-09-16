package main.java.dev.strings;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int tLength = t.length(), sLength = s.length();
        for(int i=0;i<tLength;i++){
            if(t.charAt(i)==s.charAt(j)){
                j++;
                if(j>=s.length()){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        IsSubsequence s = new IsSubsequence();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));

    }
}
