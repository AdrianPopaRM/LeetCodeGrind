package main.java.dev.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> differentCandies = new HashSet<>();
        for(int type : candyType){
            differentCandies.add(type);
        }
        return Math.min(differentCandies.size(), candyType.length / 2);
    }
}
