package main.java.dev.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length < 2) {
            return false;
        }
        if (k == 1) {
            return true;
        }

        Map<Integer, Integer> restMap = new HashMap<>();
        int currentSumRest = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSumRest = (currentSumRest + nums[i]) % k;

            if (currentSumRest == 0) {
                if(i!=0){
                    return true;
                }
            }

            if (restMap.get(currentSumRest)!=null){
                if(i-restMap.get(currentSumRest)>1){
                    return true;
                }
            }

            restMap.putIfAbsent(currentSumRest, i);
        }
        return false;
    }

//    public boolean checkSubarraySum(int[] nums, int k) {
//        if (nums.length < 2) {
//            return false;
//        }
//        if (k==1){
//            return true;
//        }
//
//        long currentSum = nums[0];
//        Map<Long, Integer> mapSum = new HashMap<>();
//        mapSum.put((long)nums[0], 0);
//
//        for(int i=1; i<nums.length; i++){
//            currentSum+= nums[i];
//            if(currentSum%k==0){
//                return true;
//            }
//            if(nums[i]==0){
//                if(nums[i-1]==0){
//                    return true;
//                }
//            }
//            mapSum.putIfAbsent(currentSum, i);
//        }
//        for(Long num : mapSum.keySet()){
//            if(mapSum.containsKey(num-k)){
//                if(mapSum.get(num)-2>=mapSum.get(num-k)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    public boolean checkSubarraySumBruteForce(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        if (k == 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int currentSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        ContinuousSubarraySum test = new ContinuousSubarraySum();
        int[] nums1 = {23, 2, 4, 6, 7};
        int[] nums2 = {1, 0, 1, 0, 1};
        int[] nums3 = {23, 2, 6, 4, 7};
        System.out.println(test.checkSubarraySum(nums1, 6));
        System.out.println(test.checkSubarraySum(nums2, 4));
        System.out.println(test.checkSubarraySum(nums3, 13));

    }
}
