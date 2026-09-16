package main.java.dev.strings;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder formatedString = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]","").toLowerCase());
        int newLength=formatedString.length();
        return formatedString.substring(0,newLength/2).equals(formatedString.reverse().substring(0,newLength/2));
    }
    public boolean mostEfficient(String s){
        StringBuilder formatedString = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]","").toLowerCase());
        int newLength=formatedString.length();
        for(int i=0; i<newLength/2;i++){
            if(formatedString.charAt(i)!=formatedString.charAt(newLength-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        ValidPalindrome s = new ValidPalindrome();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome(" "));
    }
}
