package main.java.dev.strings;

public class FirstIndexOfFirstOccurence {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static void main(String args[]){
        FirstIndexOfFirstOccurence f = new FirstIndexOfFirstOccurence();
        System.out.println(f.strStr("sadbutsad", "sad"));
        System.out.println(f.strStr("leetcode", "leeto"));
    }
}
