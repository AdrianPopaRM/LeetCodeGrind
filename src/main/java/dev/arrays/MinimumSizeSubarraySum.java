package main.java.dev.arrays;

import java.util.ArrayList;
import java.util.List;

public class MinimumSizeSubarraySum {
//    public int minSubArrayLen(int target, int[] nums) {
//        if(nums[0]>= target) {
//            return 1;
//        }
//        int[] prefixSum = new int[nums.length];
//        prefixSum[0] = 0;
//
//        int minLength = 0;
//        for(int i=1; i < nums.length; i++){
//            if(nums[i]>=target){
//                return 1;
//            }
//            prefixSum[i]=prefixSum[i-1]+nums[i-1];
//        }
//    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target) {
            return 1;
        }
        int arrSize = nums.length;
        int[] prefixSum = new int[arrSize];

        int minLength = 1000000;
        prefixSum[0] = nums[0];
        for (int i = 1; i < arrSize; i++) {
            if (nums[i] >= target) {
                return 1;
            }
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for (int i = arrSize - 1; i >= 0; i--) {
            int currentPoint = i - 1;
            if (prefixSum[i] < target) {
                break;
            }
            if(prefixSum[i]>=target){
                minLength= Math.min(i+1, minLength);
            }
            while (currentPoint >= 0) {
                int currentSum = prefixSum[i] - prefixSum[currentPoint];
                if (currentSum < target) {
                    currentPoint--;
                    continue;
                }
                if(currentSum >= target){
                    minLength = Math.min(minLength, i-currentPoint);
                    break;
                }


            }
        }
        return minLength==1000000? 0:minLength;
    }

    public int minSubArrayLenOptim(int target, int[] nums){
        int arrSize = nums.length;
        int[] prefixSum = new int[arrSize];

        prefixSum[0]= nums[0];
        for(int i=1; i<arrSize;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int[] complementary = new int[arrSize];
        for(int i=0; i<arrSize; i++){
            complementary[i] = target - prefixSum[i];
        }
    }
    public static void main(String args[]) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] nums1={2,3,1,2,4,3};
        int[] nums2={1,4,4};
        int[] nums3={1,1,1,1,1,1,1,1};
        System.out.println(test.minSubArrayLen(7, nums1));
        System.out.println(test.minSubArrayLen(4, nums2));
        System.out.println(test.minSubArrayLen(11, nums3));
    }
}
