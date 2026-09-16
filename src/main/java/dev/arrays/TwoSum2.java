package main.java.dev.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int size = numbers.length;
        for(int i=0; i<size;i++){
            if(m.containsKey(target-numbers[i])){
                return new int[]{m.get(target - numbers[i])+1, i+1};
            }
            else{
                m.put(numbers[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}
