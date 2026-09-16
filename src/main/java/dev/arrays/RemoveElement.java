package java.dev.arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k=0, index=0;
        int[] copy=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
