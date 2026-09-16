package main.java.dev.arrays;

import java.util.*;

public class TopKFrequentElements {
    //Acknowledge constraints: Define the exact input types, ranges, and expected return types verbally before typing.
    //
    //State the complexity target: Commit to the time and space constraints derived from the selected pattern.
    //
    //Draft the architecture: Use block comments to outline the sequence of operations (e.g., initialization, loop condition, state update, return condition).
    //
    //Dry-run the logic: Trace a small sample input through the commented structure aloud.
    //
    //Implement: Translate the verified outline into syntax.


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Integer> queue= new PriorityQueue<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int n : map.keySet()){
            if(queue.size()<k){
                queue.add(map.get(n));
            }
            else{
                if(queue.peek()!=null && queue.peek()<map.get(n)){
                    queue.poll();
                    queue.add(map.get(n));
                }
            }
        }
        int[] result=new int[k];
        int index=0;
        for(int n:map.keySet()){
            if(queue.contains(map.get(n))){
                result[index++]=n;
            }
        }
        return result;
    }
}
