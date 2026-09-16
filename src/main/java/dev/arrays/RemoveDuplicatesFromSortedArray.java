package main.java.dev.arrays;

import java.util.Vector;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k=0;
        Vector<Integer> freq=new Vector<>();
        for(int i=0;i<nums.length;i++){
            if(!freq.contains(nums[i])){
                freq.add(nums[i]);
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }

    public int removeDuplicatesEfficient(int[] nums) {
        int k=1, lastKnown=nums[0],count=1;
        for(int i=1;i<nums.length;i++){
            if(lastKnown!=nums[i]){
                nums[k]=nums[i];
                k++;
                lastKnown=nums[i];
                count=1;
            }
            else{
                if(count==1){
                    nums[k]=nums[i];
                    k++;
                    lastKnown=nums[i];
                    count++;
                }
            }
        }
        return k;
    }
}
