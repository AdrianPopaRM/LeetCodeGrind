package main.java.dev.arrays;

public class ProductOfArrayExceptSelf {
    //Must be solved in O(n) and cannot use DIVISION.
    public int[] productExceptSelf(int[] nums) {
        int[] output=new int[nums.length];
        int prod=1, nrZeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) prod*=nums[i];
            else nrZeros++;
        }
        if(nrZeros<2){
            for (int i = 0; i < nums.length; i++) {
                if(nrZeros==0){
                    output[i]=prod/nums[i];
                }else{
                    if(nums[i]==0) {
                        output[i] = prod;
                        return output;
                    }
                }
            }
        }
        return output;
    }

    public int[] productExceptSelfWithoutDivision(int[] nums) {
        int[] productFromLeft = new int[nums.length], productFromRight= new int[nums.length];
        productFromLeft[0]=1;
        productFromRight[0]=1;
        int currentProdLeft=nums[0], currentProdRight=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            productFromLeft[i]=currentProdLeft;
            currentProdLeft*=nums[i];
            productFromRight[i]=currentProdRight;
            currentProdRight*=nums[nums.length-1-i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=productFromLeft[i]*productFromRight[nums.length-1-i];
        }
        return nums;
    }
}
