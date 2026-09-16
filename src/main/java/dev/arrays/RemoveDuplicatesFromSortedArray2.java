package main.java.dev.arrays;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int k=1, lastKnown=nums[0];
        for(int i=1;i<nums.length;i++){
            if(lastKnown!=nums[i]){
                nums[k]=nums[i];
                k++;
                lastKnown=nums[i];
            }
        }
        return k;
    }
}