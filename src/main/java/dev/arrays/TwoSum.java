package main.java.dev.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class TwoSum {
    //Acknowledge constraints: Define the exact input types, ranges, and expected return types verbally before typing.
    //
    //State the complexity target: Commit to the time and space constraints derived from the selected pattern.
    //
    //Draft the architecture: Use block comments to outline the sequence of operations (e.g., initialization, loop condition, state update, return condition).
    //
    //Dry-run the logic: Trace a small sample input through the commented structure aloud.
    //
    //Implement: Translate the verified outline into syntax.

    //The input, output types and ranges are already defined for this problem.
    //Using HashMap gives us O(1) access time complexity. Space complexity will be O(N) (assuming each number present in initial array is unique, otherwise it would be O(n-number_of_duplicates).
    //The key for the map will be the number. The value will be a vector with all the indexes where the current number is found in the initial array.
    public int[] twoSum(int[] nums, int target) {
        //We initialize the map and the array that will be returned.
        Map<Integer, Vector<Integer>> map = new HashMap<>();
        int[] result= new int[2];

        //We go through the initial array adding each element to the HashMap. At the same time, we are performing a check to see if for the current element there exists the complementary for reaching the target. If the complementary is equal with the current number, we check if there are two indexes in order to satisfy the constraint that each number can be used only ONCE.
        for(int i=0; i<nums.length; i++){
            //We have two cases: If the key is present in map, we just add the index to the vector. IF it doesn't exist, we put it with a new vector containing the current index
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }
            else{
                Vector<Integer> v = new Vector<>();
                v.add(i);
                map.put(nums[i], v);
            }
            //Now we check for complementary
            if(map.containsKey(target-nums[i])){
                //Here we check the two mentioned cases: If target-currentNumber is equal to currentNumber, two indexes must exist. Otherwise we just return the first indexes for the complementary values
                if(target-nums[i]==nums[i]){
                    if(map.get(nums[i]).size()>=2){
                        result[0]= map.get(nums[i]).get(0);
                        result[1]= map.get(nums[i]).get(1);
                        break;
                    }
                }
                else{
                    result[0]= i;
                    result[1]= map.get(target-nums[i]).getFirst();
                    break;
                }
                //After finding a complementary pair we break so we avoid unnecessary cost
            }
        }
        //The problem specifies that there exists at least 1 solution so we don't need to check if a solution was found. We just return the expected output
        return result;
    }
}
