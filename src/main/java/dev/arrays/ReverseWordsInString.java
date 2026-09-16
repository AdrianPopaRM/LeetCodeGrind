package main.java.dev.arrays;

import java.util.Stack;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(String word : s.trim().split("\\s+")){
            stack.push(word);
        }
        while(!stack.empty()){
            result.append(stack.pop());
            if(!stack.empty()){
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static void main(String args[]){
        String s1="the sky is blue";
        String s2="  hello world  ";
        String s3="a good   example";
        ReverseWordsInString reverse=new ReverseWordsInString();
        System.out.println(reverse.reverseWords(s1));
        System.out.println(reverse.reverseWords(s2));
        System.out.println(reverse.reverseWords(s3));
    }
}
