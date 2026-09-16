package main.java.dev.arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int currentSum=0, count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            if(map.containsKey(currentSum-k)){
                count+= map.get(currentSum-k);
            }
            map.put(currentSum, map.getOrDefault(currentSum,0)+1);
        }
        Deque<Integer> s = new ArrayDeque<>();
        s.contains(1);
        
        return count;
    }
}
