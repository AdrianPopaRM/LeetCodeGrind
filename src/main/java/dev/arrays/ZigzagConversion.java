package main.java.dev.arrays;

import java.lang.reflect.Array;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        Character[][] matrix= new Character[numRows][1000];
        int currentCol=0, currentIndex=0;
        boolean stop=false;
        while(!stop){
            for(int i=0; i<numRows;i++){
                if(currentIndex==s.length()){
                    stop=true;
                    break;
                }
                matrix[i][currentCol] = s.charAt(currentIndex++);
            }
            currentCol++;
            for(int i=numRows-2;i>0;i--){
                if(currentIndex==s.length()){
                    stop=true;
                    break;
                }
                matrix[i][currentCol++]= s.charAt(currentIndex++);
            }
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<1000;j++){
                if(matrix[i][j]!=null&&matrix[i][j]!=' '){
                    result.append(matrix[i][j]);
                }
            }
        }
        return result.toString();
    }
    public static void main(String args[]){
        String s1 = "PAYPALISHIRING";
        String s2 = "A";
        String s3 = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        ZigzagConversion zig= new ZigzagConversion();
//        System.out.println(zig.convert(s1,3));
//        System.out.println(zig.convert(s1,4));
//        System.out.println(zig.convert(s2,1));
        System.out.println(zig.convert(s3,1));

    }
}
